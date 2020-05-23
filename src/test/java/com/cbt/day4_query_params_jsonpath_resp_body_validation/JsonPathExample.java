package com.cbt.day4_query_params_jsonpath_resp_body_validation;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JsonPathExample {
    @Test
    public void jsonPathExamples(){
        Response response = given().
                queryParam("symbols", "USD").
                queryParam("base", "PHP").
                when().
                get("https://api.exchangeratesapi.io/latest");

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        // STRING
        // get the base, date: keys in the top level object
        String base = jsonPath.getString("base");
        System.out.println("base = " + base);
        String date = jsonPath.getString("date");
        System.out.println("date = " + date);
        // get the rate USD (not top level object)
        String usd = jsonPath.getString("rates.USD");
        System.out.println("usd = " + usd);

        // Jsonpath class can do automatic conversions to different types
        // DOUBLE
        double usdDouble = jsonPath.getDouble("rates.USD");
        System.out.println("usdDouble = " + usdDouble);

        // MAP. only object or key/value pairs can converted to map
        Map<String, Object> rates = jsonPath.getMap("rates");
        System.out.println("rates = " + rates);
        System.out.println("rates.get(\"USD\") = " + rates.get("USD"));

        // get the top level json into a map
        Map<String, Object> wholeObject = jsonPath.getMap("");
        System.out.println("wholeObject = " + wholeObject);

    }
    /*
    make query with base PHP
    verify that body contains base with value PHP, content type, status
    use body method
     */
    @Test
    public void testPHP(){
        given().
                queryParam("base", "PHP").
        when().
                get("https://api.exchangeratesapi.io/latest").
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("base", is("PHP"));
    } // break 3.01

    /*
    make query with base PHP
    verify that body contains base with value PHP, content type, status
    use jsonpath
     */
    @Test
    public void testPHPAgain(){
        Response response = given().
                queryParam("base", "PHP").
                when().
                get("https://api.exchangeratesapi.io/latest");
        response.then().statusCode(200).
                contentType(ContentType.JSON);

        String base = response.jsonPath().getString("base");
        assertThat(base, is("PHP"));

    }

}
