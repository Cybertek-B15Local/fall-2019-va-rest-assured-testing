package com.cbt.tests.day8_more_serial;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UINamesExercise {
    /*
    send get request to ui names
    query param country is Mexico
    verify response 200
    verify country Mexico
    verify name is not empty
     */
    @Test
    public void testMexico(){
        given().
                queryParam("region", "Mexico").
        when().
                get("https://cybertek-ui-names.herokuapp.com/api/").
                prettyPeek().
        then().
                statusCode(200).
                body("region", is("Mexico")).
                body("name", not(emptyOrNullString()));

    }



}
