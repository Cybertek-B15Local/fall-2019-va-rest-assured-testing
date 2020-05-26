package com.cbt.day5_authentication_authorization;

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
                queryParam("t", "That Thing called Tadhana").
        when().
                get("https://omdbapi.com").
                prettyPeek().
        then().
                statusCode(200);
    }

}
