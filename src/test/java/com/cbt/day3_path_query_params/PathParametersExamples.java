package com.cbt.day3_path_query_params;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PathParametersExamples {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }

    /**
     * make a get request to /student/:id and get single student information
     * provide the path parameters
     * verify status code
     * verify student name
     */
    @Test
    public void testVasylFromIndia(){
        given().
                log().all().
                pathParam("id", 10521).
        when().
                get("/student/{id}").
                prettyPeek().
        then().statusCode(200);
    }

    /**
     * same test as above but with a different id
     */
    @Test
    public void testVera(){
        given().
                log().all().
                pathParam("id", 10662).
        when().
                get("student/{id}").
                prettyPeek().
        then().statusCode(200);
    }

}
// 7.26