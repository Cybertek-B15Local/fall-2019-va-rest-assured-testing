package com.cbt.day6_ssl_serialization_deserialization;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HandlingSSLInRest {


    @Test
    public void badSsl(){
        given().
                        relaxedHTTPSValidation().
                when().get("https://untrusted-root.badssl.com/").
                        prettyPeek().
                then().
                        statusCode(200);
    }

    /*
    truststore -->  it holds the list of certificates
    keystore -->  it holds the list of keys
     */
    @Test
    public void trustStore(){
        given().
                trustStore("/path/to/file", "password").
         when().
                get("/my/api").
        then().statusCode(200);
    }

    /*
   truststore -->  it holds the list of certificates
   keystore -->  it holds the list of keys
    */
    @Test
    public void keyStore(){
        given().
                keyStore("/path/to/file", "password").
        when().
                get("/my/api").
        then().statusCode(200);
    }

// break 7.39



}
