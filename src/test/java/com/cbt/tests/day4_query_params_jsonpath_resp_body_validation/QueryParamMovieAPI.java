package com.cbt.tests.day4_query_params_jsonpath_resp_body_validation;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class QueryParamMovieAPI {

    /*
    title = Avatar
    apiKey = e0484f01
     */
    @Test
    public void test(){
        given().
               log().all().
               queryParam("apiKey", "e0484f01").
               queryParam("t", "Titanic").
        when().
            get("https://omdbapi.com/").
            prettyPeek().
        then().statusCode(200);
    }
}
