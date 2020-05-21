package com.cbt.day2_endpoints_response;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CustomHeadersTests {
/*
Accept --> is a header that is part of request.
It is used to indicate in what format we want the response in
if i want the response to json, i send with header application/json

then response will be in json and it will have header content-type with value json
 */
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
        given().
                log().all().
                header("Accept", "application/xml").
        when().
                get("/spartans").
        then().
                log().all().
                contentType(ContentType.XML);
    }

    /**
     * send a get request to http://54.224.118.38:8000/api
     * include header Accept, value = json
     * verify that response content type is json
     */
    @Test
    public void testJson(){
        given().
                log().all().
                header("Accept", "application/json").
        when().
                get("/spartans").
        then().
                log().all().
                contentType(ContentType.JSON);
    }

    /**
     * send a get request to http://54.224.118.38:8000/api
     * do not include any headers
     * verify that response content type is json
     */
    @Test
    public void defaultType(){
        given().
                log().all().
        when().
                get("/spartans").
        then().
                log().all().
                contentType(ContentType.JSON);
    }

}
