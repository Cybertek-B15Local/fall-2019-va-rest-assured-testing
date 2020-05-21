package com.cbt.day2_endpoints_response;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomHeadersTests {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://54.224.118.38:8000/api";
    }

    /**
     * send a get request to http://54.224.118.38:8000/api
     * include header Accept, value = application
     * verify that response content type is xml
     */

    @Test
    public void xmlTest(){

    }


    /**
     * send a get request to http://54.224.118.38:8000/api
     * include header Accept, value = json
     * verify that response content type is json
     */

    /**
     * send a get request to http://54.224.118.38:8000/api
     * do not include any headers
     * verify that response content type is json
     */
}
