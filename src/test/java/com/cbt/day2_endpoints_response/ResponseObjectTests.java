package com.cbt.day2_endpoints_response;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class ResponseObjectTests {


    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }

    @Test
    public void verifyStudentInformation(){
        // response -> represents the response that we get from the server
        Response response = when().get("/student/10662");

        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.header("Content-Type"));
        System.out.println(response.headers());


        response.print();
        // verify status
        response.then().statusCode(200);
        // verify response contains Vera
        String resString = response.asString();
        assertThat(resString, containsString("Vera"));

    }


    @Test
    public void verifyTeacherInformation(){
            Response response = get("/teachers/4712");
            response.prettyPrint();

            assertThat(response.asString(), containsString("Darleen"));
        }

}
