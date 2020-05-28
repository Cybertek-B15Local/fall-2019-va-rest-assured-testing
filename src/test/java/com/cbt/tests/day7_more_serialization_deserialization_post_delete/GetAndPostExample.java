package com.cbt.tests.day7_more_serialization_deserialization_post_delete;

import com.cbt.pojos.Spartan;
import com.cbt.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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


    @Test
    public void testPost(){
        // create a spartan pojo with some random name, gender, phone number
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String gender;
        if (faker.bool().bool()) {
            gender = "Female";
        } else {
            gender="Male";
        }
        String phone = faker.number().digits(10);

        Spartan newSpartan = new Spartan(name, gender,phone);
        System.out.println("newSpartan = " + newSpartan);

        given().
                auth().basic("admin", "admin").
                contentType(ContentType.JSON).
                body(newSpartan).
                log().all().
        when().
                post("/api/spartans/").prettyPeek().
        then().
                statusCode(201);

        // break 7.44

    }

}
