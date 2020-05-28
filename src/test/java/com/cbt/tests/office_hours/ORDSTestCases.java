package com.cbt.tests.office_hours;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ORDSTestCases {



    /*
    get all the employees and their depart ids.
    verify that department id points to the existing record in the departmetns table
    verify response 200
    verify department name is not empty
     */
    @Test
    public void departamentes(){
        List<Integer> depIds = given().
                queryParam("limit", 110).
                when().
                get("/employees").jsonPath().getList("items.department_id");
        System.out.println(depIds);
        // remove duplicates
        // Set<Integer>uniqueDepIds=new HashSet<>(depIds);

        Set<Integer> uniqueDepIds = new HashSet<>();
        uniqueDepIds.addAll(depIds);
        System.out.println(uniqueDepIds);

        // get each separately
        for (Integer depId : uniqueDepIds) {
            // call the department/:id to get the specific department
            // verify 200, verify name is not null
            given().
                    pathParam("id", depId).
            when().
                    get("/departments/{id}").
                    prettyPeek().
            then().statusCode(200).and().body("department_name", not(emptyOrNullString()));
        }

    }

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://54.146.89.247:1000/ords/hr/";
    }

     /*
    get all the records from the employees table using the /employees
    verify that number of employees is more than 100

     */

    @Test
    public void employeesTest(){
        // turns out you can only get 25 employees per response.
        // need to use extra query parameter to get all at once
        // row_count
        Response response = given().
                                  queryParam("limit", 110).
                            when().
                                     get("/employees");
        response.
//                prettyPeek().
                then().statusCode(200);

        // get all the employee into a list of maps. each map represents one employee
       List<Map<String, Object>> employees = response.jsonPath().getList("items");
        System.out.println(employees.size());
        System.out.println(employees.get(1));
        assertThat(employees.size(), greaterThan(100));
    }

}
/*
{
   id:12
   name:nnn
},
{
    id:13
   name:mmmm
}

 */