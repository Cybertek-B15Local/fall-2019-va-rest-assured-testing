package com.cbt.tests.office_hours;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class HarryPotterApiTests {
    String key = "$2a$10$FTnApxTj6LQ7NL/VhjkUdOpnqcyxROT.lAVCEDFVski16Rqgy8pBS";

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI="https://www.potterapi.com/v1/";
    }
    @Test
    public void sortingHatTest(){
        given().
            log().all().
        when().
                get("sortingHat").prettyPeek().
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                body( Matchers.anyOf(
                        containsString("Gryffindor"),
                        containsString("Ravenclaw"),
                        containsString("Slytherin"),
                        containsString("Hufflepuff")));
    }

    @Test
    public void badKeyTest(){
        Response response = given().log().all().
                header("Accept", "application/json").
                queryParam("key", "invalid").
         when().
                get("characters").prettyPeek();


        response.then().
                statusCode(is(401)).
                and().contentType("application/json; charset=utf-8");
        response.then().statusLine(containsString("Unauthorized"));
        response.then().body("error", is("API Key Not Found"));

    }

}
