package com.cbt.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationUtility {

    public static String getLibrarianToken() {
            String username = ConfigurationReader.getProperty("library1_librarian_email");
            String password = ConfigurationReader.getProperty("library1_librarian_password");

        Response response = given().
                    formParam("email", username).
                    formParam("password", password).
                when().
                    post("login").prettyPeek();
        response.then().statusCode(200);

        return response.jsonPath().getString("token");

    }
}
