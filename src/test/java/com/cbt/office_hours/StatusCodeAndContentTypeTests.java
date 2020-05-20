package com.cbt.office_hours;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class StatusCodeAndContentTypeTests {

    /**
     * TC 01
     * make a get request to https://api.github.com/users/cybertekschool
     * verify status code 200
     * verify content type application/json
     * verify header server GitHub.com
     */
    @Test
    public void githubTest(){
        RestAssured.
                when().get("https://api.github.com/users/cybertekschool").
                         prettyPeek().
                then().statusCode(200).
                        contentType(ContentType.JSON).
                        header("server", "GitHub.com");
    }


    /**
     * TC 02
     * make a get request to https://google.com
     * verify status code 200
     * verify content type text/html
     */
    @Test
    public void googleTest(){
        RestAssured.
            when().get("https://google.com").
                prettyPeek().
            then().assertThat().statusCode(200).
                and().contentType(ContentType.HTML);
    }

}
