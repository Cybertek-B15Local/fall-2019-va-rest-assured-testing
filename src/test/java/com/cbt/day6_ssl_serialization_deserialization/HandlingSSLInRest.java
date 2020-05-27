package com.cbt.day6_ssl_serialization_deserialization;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class HandlingSSLInRest {


    @Test
    public void badSsl(){
        RestAssured.
                given().
                        relaxedHTTPSValidation().
                when().get("https://untrusted-root.badssl.com/").
                        prettyPeek().
                then().
                        statusCode(200);
    }




}
