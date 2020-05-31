package com.cbt.tests.day9_schema_validation_more_api_tests;

import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class SchemaValidationTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan_base_url");
        RestAssured.authentication = basic("admin", "admin");
    }

    @Test
    public void validateJsonInClassPath() {
             given().
                    pathParam("id", 44).
             when().
                     get("api/spartans/{id}").prettyPeek().
             then().
                     statusCode(200).
                     body(JsonSchemaValidator.matchesJsonSchemaInClasspath("spartan-schema.json"));
          // matchesJsonSchemaInClasspath --> verifies that response body matches the schema
         // in the test/resources folder
            }

    @Test
    public void validateJsonNotInClassPath(){
        // when we want to use a file from specific location, we create file object, then pass with to the JsonSchemaValidator
        File file = new File("src/test/resources/spartan-schema.json");

        given().
                pathParam("id", 45).
        when().
                get("api/spartans/{id}").prettyPeek().
        then().
                statusCode(200).
                body(JsonSchemaValidator.matchesJsonSchema(file));

    }


}
