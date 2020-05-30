package com.cbt.tests.day8_more_serial;

import com.cbt.pojos.Employee;
import com.cbt.pojos.Link;
import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ORDSSerializationTest {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI= ConfigurationReader.getProperty("ords_base_url");
    }

    @Test
    public void getSteven(){
        Response response = given().
                pathParam("id", 100).
        when().
                get("employees/{id}").
                prettyPeek();

        response.then().
                statusCode(200);

        Employee employee = response.as(Employee.class);
        System.out.println(employee);

        List<Link> links = employee.getLinks();
        System.out.println(links);
    }


    @Test
    public void getAaaaalOfTheEmployees(){
        Response response = when().get("employees").prettyPeek();

        response.then().statusCode(200);

        List<Employee> items = response.jsonPath().getList("items", Employee.class);

        System.out.println("Number of employees = " + items.size());

        Employee firstEmlpoyee = items.get(0);
        System.out.println("firstEmlpoyee = " + firstEmlpoyee.getFirstName());
    }
}
