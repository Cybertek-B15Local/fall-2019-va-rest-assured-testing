package com.cbt.day2_endpoints_response;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EndpointsDemo {
    // FULL URL :   http://api.openrates.io/latest
   // BASE -->  http://api.openrates.io
   // endpoint --> /latest

    // rest assured will add the base to the path to create the final url

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://api.openrates.io";
    }

    @Test
    public void getLatest(){
        RestAssured.
                when().get("/latest").
                        prettyPeek().
                then().statusCode(200);
    }


    @Test
    public void getHistoricRate(){
        RestAssured.
                when().get("/2010-01-01").prettyPeek().
                then().statusCode(200);
    }



}
