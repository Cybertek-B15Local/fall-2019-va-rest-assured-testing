package com.cbt.tests.day11_cookie_and_extent_report;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CookieTests {

    /*
    login to zero bank app using form params
        user_login: username and user_password: password
     */
    @Test
    public void getCookieTest(){
        Response postResponse =
                given().
                    formParam("user_login", "username").
                    formParam("user_password", "password").
                    log().all().
                when().
                    post("http://zero.webappsecurity.com/signin.html");
        // cookie is returned as part of teh response.
        // getDetailedCookie  --> returns the cookie with given name
        Cookie cookie = postResponse.getDetailedCookie("JSESSIONID");
        System.out.println("cookie = " + cookie);
    }

}
