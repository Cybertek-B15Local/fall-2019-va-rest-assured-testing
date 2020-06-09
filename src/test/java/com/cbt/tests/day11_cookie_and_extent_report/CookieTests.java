package com.cbt.tests.day11_cookie_and_extent_report;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class CookieTests {

    /*
    login to zero bank app using form params
        user_login: username and user_password: password
     */
    @Test
    public void getCookieTest(){
        // GET THE COOKIE
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

        // LOGIN USING THE COOKIE
        // send the request with cookie attached
        given().
                cookie(cookie).
        when().
                get("http://zero.webappsecurity.com/bank/online-statements.html").
                prettyPeek().
        then().
                statusCode(200).
                body(not(containsString("login")));
    }

}
