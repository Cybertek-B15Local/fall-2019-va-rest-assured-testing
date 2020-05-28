package com.cbt.tests.day7_more_serialization_deserialization_post_delete;

import com.cbt.pojos.Spartan;
import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAndPostExample {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan_base_url");
    }
    @Test
    public void testGet(){
        Response response =
                given().
                        auth().basic("admin", "admin").
                        pathParam("id", 5).
                when().
                        get("/api/spartans/{id}").prettyPeek();

        response.then().statusCode(200);

        Spartan spartan = response.as(Spartan.class);

        System.out.println("spartan.getName() = " + spartan.getName());
    }
}
