package com.cbt.day4_query_params_jsonpath_resp_body_validation;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MoreQueryParameters {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://api.exchangeratesapi.io";
    }

    /*
    get the rates against USD only
     */
    @Test
    public void symbolsTest(){
        given().
               queryParam("symbols","USD").
               log().all().
        when().
                get("/latest").
                prettyPeek().
        then().
                statusCode(200);
    }

    /*
    base  PHP
    symbols USD
     */
    @Test
    public void baseAndSymbolsTest(){
        given().
                log().all().
                queryParam("symbols", "USD").
                queryParam("base", "PHP").
        when().
                get("/latest").
                prettyPeek().
        then().
                statusCode(200);
    }

    /*
    base  PHP
    symbols USD
     */
    @Test
    public void baseAndSymbolsTestWithMap(){
        Map<String, String> parametersMap=new HashMap<>();
        parametersMap.put("base", "PHP");
        parametersMap.put("symbols", "USD");

        given().
                log().all().
                queryParams(parametersMap).
        when().
                get("/latest").
                prettyPeek().
        then().statusCode(200);

    }

}
