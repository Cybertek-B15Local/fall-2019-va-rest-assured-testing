package com.cbt.day3_path_query_params;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class QueryParamsExamples {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://api.exchangeratesapi.io";
    }

    /*
    call the exchangeratesapi with query param base=PHP
    berify status code 200
     */
    @Test
    public void testPHP(){
        given().
                log().all().
                queryParam("base", "PHP").
        when().
                get("/latest").
                prettyPeek().
        then().statusCode(200);
    }

}
