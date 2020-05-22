package com.cbt.day3_path_query_params;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class NotFound404Tests {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }

    /*
    make a request to student endoint
    provide no existing id as a parameter
    verify status 404
    verify response contains Student with id =  NOT FOUND!
     */
    @Test
    public void verifyErrorMessageAnd404(){
        Response response = given().
                    pathParam("id", 1).
                when().
                    get("/student/{id}");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        response.then().statusCode(404);
        assertThat(response.asString(), containsString("NOT FOUND!"));
    }

    @Test
    public void test404(){
        given().
                pathParam("id", 1).
        when().
                get("/student/{id}").
        then().
                statusCode(404);

    }

}
