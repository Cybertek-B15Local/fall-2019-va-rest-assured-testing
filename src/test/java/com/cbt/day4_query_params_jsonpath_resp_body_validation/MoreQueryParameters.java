package com.cbt.day4_query_params_jsonpath_resp_body_validation;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MoreQueryParameters {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://api.exchangeratesapi.io";
    }

    /*
    get the rates against USD only
     */
    @Test
    public void symbolsTest(){
        given().
               queryParam("symbols","USD").
               log().all().
        when().
                get("/latest").
                prettyPeek().
        then().
                statusCode(200);
    }

    /*
    base  PHP
    symbols USD
     */
    @Test
    public void baseAndSymbolsTest(){
        given().
                log().all().
                queryParam("symbols", "USD").
                queryParam("base", "PHP").
        when().
                get("/latest").
                prettyPeek().
        then().
                statusCode(200);
    }

    /*
    base  PHP
    symbols USD
     */
    @Test
    public void baseAndSymbolsTestWithMap(){
        Map<String, String> parametersMap=new HashMap<>();
        parametersMap.put("base", "PHP");
        parametersMap.put("symbols", "USD,GBP");

        given().
                log().all().
                queryParams(parametersMap).
        when().
                get("/latest").
                prettyPeek().
        then().statusCode(200);

    }
    // FROM NIJAT:    https://api.exchangeratesapi.io/latest?symbols=USD,GBP
    ///         key:  symbols
    //          value: USD,GBP
    //                https://api.exchangeratesapi.io/latest?symbols=USED&base=PHP
    //          first param: key symbols, value: USD
    //          second param: key base, value: PHP

    // https://api.exchangeratesapi.io/latest?symbols=USD%2CGBP&base=PHP
        // first  symbols=USD%2CGBP
    // second  base=PHP

//   https://www.google.com/search?
//   q=selenium&
//   oq=selenium&
//   aqs=chrome..69i57j69i60l2j69i65l3j69i60l2.2095j0j4&
//   sourceid=chrome&
//   ie=UTF-8



}
