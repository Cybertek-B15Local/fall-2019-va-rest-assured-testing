package com.cbt.day5_authentication_authorization;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TokenBasedAuthentication {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI="http://library2.cybertekschool.com/rest/v1";
    }

    @Test
    public void tokenAuthentication(){
        // get token from the login method
        String token = given().
                            log().all().
                            formParam("email", "student27@library").
                            formParam("password", "kkMksO2i").
                     when().
                         post("/login").jsonPath().getString("token");


        // use the token to get all book categories
        given().
                header("x-library-token", token).
                log().all().
        when().
            get("/get_book_categories").
            prettyPeek().
        then().statusCode(200);
    }
}
