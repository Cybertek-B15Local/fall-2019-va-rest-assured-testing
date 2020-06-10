package com.cbt.tests.day12_could_be_last_day;

import com.cbt.pojos.Spartan;
import com.cbt.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PatchVsPutExample {

    /**
     * CRUD --> create, read,   update,     delete
     * SQL -->  insert, select, update,     delete
     * REST --> post,   get,    put/patch,  delete
     * <p>
     * post --> new row/record is added to the database
     * get --> no changes in the database
     * put --> when updating with put we need to provide the whole information,
     * new row is added to the database with the updated information
     * <p>
     * patch  --> we only provide the information which we want to update and also id information
     * delete  --> a row / record is removed from database
     * <p>
     * PUT
     * id fname lname title
     * 1 luba  n     another ceo
     * 2 alina n    another another ceo
     * 3 alina p    another another ceo
     * <p>
     * <p>
     * PATCH
     * id fname lname title
     * 1  luba  n     another ceo
     * 2  alina n    another another ceo
     */

    @Test
    public void put() {
        RestAssured.baseURI = ConfigurationReader.getProperty("spartan_base_url");
        // create pojo
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String gender;
        if (faker.bool().bool()) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        String phone = faker.number().digits(10);
        Spartan spartan = new Spartan(name, gender, phone);

        // create new spartan, verify 201, save id

        Response postResponse =
                given().
                        log().all().
                        auth().basic("admin", "admin").
                        contentType(ContentType.JSON).
                        body(spartan).
                        when().
                        post("/api/spartans").prettyPeek();
        postResponse.then().statusCode(201).and().body("success", is("A Spartan is Born!"));

        int id = postResponse.path("data.id");
        System.out.println("id = " + id);

        // get the spartan information using the id
        Response getResponse = given().
                auth().basic("admin", "admin").
                pathParam("id", id).
                when().
                get("api/spartans/{id}").prettyPeek();
        getResponse.then().statusCode(200);

        // UPDATE spartan info
        spartan.setName(faker.name().fullName());

        given().
                auth().basic("admin", "admin").
                pathParam("id", id).
                contentType(ContentType.JSON).
            body(spartan).
                when().
                put("/api/spartans/{id}").prettyPeek().
            then().
                statusCode(204);
        // GET THE NEW SPARTAN INFORMATION

        getResponse = given().
                auth().basic("admin", "admin").
                pathParam("id", id).
                when().
                get("api/spartans/{id}").prettyPeek();
        getResponse.then().statusCode(200);

    }
}
