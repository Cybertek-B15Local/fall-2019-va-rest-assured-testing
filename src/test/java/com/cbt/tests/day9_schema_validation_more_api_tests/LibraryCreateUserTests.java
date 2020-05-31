package com.cbt.tests.day9_schema_validation_more_api_tests;

import com.cbt.utilities.AuthenticationUtility;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.LibraryUserUtility;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LibraryCreateUserTests {
    /*
    1. Student should not be able to create users
    2. Librarian should not be able create admin users
    3. Librarian should be able create librarian users
    4. Librarian should be able create student users
    5. Librarian should not be able create users with wrong group id
    6. Librarian should not be able create users with wrong status
    7. Librarian should not be able create users with missing fields
     */

    // RequestSpecification --> object that represents api request, just like Response class represents api response
    static RequestSpecification request;
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("library1_base_url");
        String token = AuthenticationUtility.getLibrarianToken();
        request = given().header("x-library-token", token).log().all();
    }

    @Test
    @DisplayName("Librarians cannot create admins")
    public void librariansCannotCreateAdmins(){
        request.
                formParam("user_group_id", 1).
        when().
                post("add_user").prettyPeek().
        then().
//                statusCode(403).
                contentType(ContentType.JSON).
                body("error", is("You do not add/edit admins."));

    }

    @Test
    @DisplayName("Librarian should not be able create users with wrong group id")
    public void wrongGroupId(){
        request.
                formParam("full_name", "john doe").
                formParam("email", "jon.doe@somemail.com").
                formParam("password", "admin").
                formParam("user_group_id", 44).
                formParam("status", "active").
                formParam("start_date", "2020-05-05").
                formParam("end_date", "2021-05-05").
                formParam("address", "123 main st").
        when().
                post("add_user").prettyPeek().
        then().
                statusCode(500).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Librarian should not be able create users with wrong status")
    public void wrongStatus(){
        request.
                formParam("full_name", "john doe").
                formParam("email", "jon.doe@somemail.com").
                formParam("password", "admin").
                formParam("user_group_id", "3").
                formParam("status", "super-active").
                formParam("start_date", "2020-05-05").
                formParam("end_date", "2021-05-05").
                formParam("address", "123 main st").
        when().
                post("add_user").prettyPeek().
        then().
                statusCode(not(200)).
                contentType(ContentType.JSON);
    }


    @Test
    @DisplayName("Create student user test")
    public void createStudentTest(){
        Map<String, ?> user = LibraryUserUtility.createUser(3);
        request.
                formParams(user).
        when().
                post("add_user").prettyPeek().
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("message", is("The user has been created.")).
                body("user_id", not(emptyOrNullString()));
    }

    @Test
    @DisplayName("Create, get, update and get again")
    public void endToEnd(){
        // POST NEW USER
        Map<String, ?> user = LibraryUserUtility.createUser(3);
        Response postResponse =
                request.
                    formParams(user).
                when().
                    post("add_user").prettyPeek();
        postResponse.then().statusCode(200);
        String id = postResponse.path("user_id");
        System.out.println("id = " + id);
        // GET USER  TODO not working due to id issue
        request.
                pathParam("id", id).
        when().
                get("get_user_by_id/{id}").
                prettyPeek().
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", equalTo(id)).
                body("full_name", equalTo(user.get("full_name"))).
                body("email", equalTo(user.get("email"))).
                body("password", not(emptyOrNullString())).
                body("user_group_id", equalTo("3"));

        // UPDATE USER INFORMATION
       given().
               header("x-library-token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoiMzQwIiwiZnVsbF9uYW1lIjoiVGVzdCBMaWJyYXJpYW4gMjIiLCJlbWFpbCI6ImxpYnJhcmlhbjIyQGxpYnJhcnkiLCJ1c2VyX2dyb3VwX2lkIjoiMiJ9LCJpYXQiOjE1OTA5NTgwNTksImV4cCI6MTU5MzU1MDA1OX0.suxNisSgCsTXFxJD5RZ3qgiCWXEJqvo-RS-UKgvCSYM").
                formParams(user).
        when().
                patch("update_user").prettyPeek().
        then().
                statusCode(200);
    }
}