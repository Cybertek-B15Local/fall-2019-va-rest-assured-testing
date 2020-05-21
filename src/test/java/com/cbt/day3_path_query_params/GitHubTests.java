package com.cbt.day3_path_query_params;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GitHubTests {


    /*
    get user from github from /users/:username
    base url https://api.github.com
     */

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI="https://api.github.com";
    }

    /*
    get github info for selimpcf
     */

    @Test
    public void testselimpcf(){
        given().
                pathParam("username", "selimpcf").
        when().
                get("/users/{username}").
                prettyPeek().
        then().statusCode(200);
    }

}
