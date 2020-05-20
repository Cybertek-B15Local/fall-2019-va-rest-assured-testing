package com.cbt.day2_endpoints_response;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class LogginInRestAssured {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://api.openrates.io";
    }
}
