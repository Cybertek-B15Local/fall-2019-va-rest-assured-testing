package com.cbt.day1_intro;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RestAssuredIntro {

    /**
     * make a get request to api.zippopotam.us/us/90210
     * verify that status code is 200
     */
    @Test
    public void testStatusCode(){
            // in rest assured we use gherkin style given when then
        // GIVEN --> used to prepare the request with custom parameters and headers
        // WHEN used to send the request
        // THEN used for verifying the request
        RestAssured.
                given().
                when().get("http://api.zippopotam.us/us/22102").
                then().statusCode(200);
    }

    /**
     make a get request to http://api.openrates.io/latest
     * verify that status code is 200
     *
     * 1 --> information
     * 2 --> success
     * 3 --> redirect
     * 4 --> client error
     * 5 --> server error
     */
    @Test
    public void testStatusCode2(){
        RestAssured.
                when().get("http://api.openrates.io/latest").
                then().statusCode(200);
    }


/**
 make a get request to http://api.openrates.io/latest
 * verify that status code is 200
 */
    @Test
    public void printResponse(){
        // prettyPeek --> prints the response
        RestAssured.
                when().get("http://api.openrates.io/latest").
                        prettyPeek().
                then().statusCode(200);
    }


    /**
     * make a get request to http://api.openrates.io/latest
     *  verify that status code is 200
     *  verify header response type application/json
     *
     */

    @Test
    public void verifyContentType(){
        // statusCode --> veriy code
        // contentType --> verify the header content type
        RestAssured.
                when().get("http://api.openrates.io/latest").
                        prettyPeek().
                then().statusCode(200).contentType(ContentType.JSON);

        // SAME TEST WITH SOME SYNTACTIC SUGAR
        RestAssured.
                when().get("http://api.openrates.io/latest").
                        prettyPeek().
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);

        // SAME TEST BUT VERIFY HEADER DIFFERENTLY
        RestAssured.
                when().get("http://api.openrates.io/latest").
                    prettyPeek().
                then().statusCode(200).contentType("application/json");

        // SAME TEST BUT VERIFY HEADER DIFFERENTLY DIFFERENTLY
        RestAssured.
                when().get("http://api.openrates.io/latest").
                prettyPeek().
                then().statusCode(200).header("Content-Type", "application/json");
    }

    /**
     * make a get request to http://api.zippopotam.us/us/22102
     *  verify that status code is 200
     *  verify header response type application/json
     *  verify header Charset UTF-8
     */
    @Test
    public void testStatusCodeAndHeader(){
        RestAssured.
                when().
                        get("http://api.zippopotam.us/us/20007").
                        prettyPeek().
                then().statusCode(200).
                    and().contentType(ContentType.JSON).
                    and().header("Charset", equalTo("UTF-8"));
    }
}







