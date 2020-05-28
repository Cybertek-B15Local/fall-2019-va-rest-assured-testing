package com.cbt.tests.day5_authentication_authorization;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthenticaionExamples {

    @Test
    public void basicPreemptive(){
        given().
                auth().preemptive().basic("admin", "admin").
        when().
                get("http://54.146.89.247:8000/api/spartans").
        then().statusCode(200);
    }

    @Test
    public void basicChallenged(){
        given().
                auth().basic("admin", "admin").
        when().
                get("http://54.146.89.247:8000/api/spartans").
        then().statusCode(200);
    }

    @Test
    public void apiKeyExample(){
        given().
                queryParam("apiKey", "e0484f01").
                queryParam("t", "Kung Fury").
        when().
                get("https://omdbapi.com").
                prettyPeek().
        then().
                statusCode(200);
    } // 7.35



    @Test
    public void testLogin(){
        RestAssured.baseURI="http://library2.cybertekschool.com/rest/v1";
        given().
                log().all().
                formParam("email", "librarian16@library").
                formParam("password", "8BzUhhaU").
        when().
                post("/login").
                prettyPeek().
                then().statusCode(200);
    }


}