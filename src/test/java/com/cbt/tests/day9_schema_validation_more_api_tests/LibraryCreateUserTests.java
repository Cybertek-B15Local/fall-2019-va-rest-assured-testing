package com.cbt.tests.day9_schema_validation_more_api_tests;

import com.cbt.utilities.AuthenticationUtility;
import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class LibraryCreateUserTests {
    /*
    1. Student should not be able to create users
    2. Librarian should not be able create admin users
    3. Librarian should be able create librarian users
    4. Librarian should be able create student users
    5. Librarian should not be able create users with wrong group id
    6. Librarian should not be able create users with status
    7. Librarian should not be able create users with missing fields
     */

    @BeforeAll
    public void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("library1_base_url");
        String token = AuthenticationUtility.getLibrarianToken();
        RestAssured.head("x-library-token", token);
    }


}
