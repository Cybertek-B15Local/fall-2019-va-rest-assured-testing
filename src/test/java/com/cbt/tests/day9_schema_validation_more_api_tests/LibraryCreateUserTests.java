package com.cbt.tests.day9_schema_validation_more_api_tests;

import com.cbt.utilities.AuthenticationUtility;
import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class LibraryCreateUserTests {
    /*
    1. Student should not be able to create users
    2. Librarian should not be able create admin users
    3. Librarian should be able create librarian users
    4. Librarian should be able create student users
    5. Librarian should not be able create users with wrong group id
    6. Librarian should not be able create users with status
    7. Librarian should not be able create users with missing fields
     */

    // RequestSpecification --> object that represents api request, just like Response class represents api response
    static RequestSpecification request;
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("library1_base_url");
        String token = AuthenticationUtility.getLibrarianToken();
        request = given().header("x-library-token", token);
    }

    @Test
    public void test(){
        request.
                formParam("user_group_id", 1).
        when().
                post("add_user").prettyPeek().
        then().
//                statusCode(403).
                contentType(ContentType.JSON).
                body("error", is("You do not add/edit admins."));

    }



}
