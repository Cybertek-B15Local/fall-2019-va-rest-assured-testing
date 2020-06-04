package com.cbt.tests.day8_more_serial;

import com.cbt.pojos.Employee;
import com.cbt.pojos.Link;
import com.cbt.pojos.Student;
import com.cbt.utilities.ConfigurationReader;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.config.DecoderConfig;
import io.restassured.config.EncoderConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.mapper.ObjectMapperType.GSON;

public class ORDSSerializationTest {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI= ConfigurationReader.getProperty("ords_base_url");

//        // pre configure the rest assured to use the custom Gson object mapper
//        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
//                .gsonObjectMapperFactory(
//                        (type, s) -> new GsonBuilder()
//                                .setPrettyPrinting()
//                                .create());
//        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(config);

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

        // // this it used the default. deafult is whatever we have in the pom file
        // what if we have both gson and jackson-databind the pom file, then it prefers jackson over gson accroding to docs
        Employee employee = response.as(Employee.class);

        // We can tell rest assured to explicitly use GSON over others.
        // in the as method add second optional parameter to specify the mapper type
//        Employee employee = response.as(Employee.class, ObjectMapperType.GSON);
        System.out.println(employee);

        List<Link> links = employee.getLinks();
        System.out.println(links);
    }


    @Test
    public void getAaaaalOfTheEmployees(){

        Response response = when().get("employees");

        response.then().statusCode(200);

        List<Employee> items = response.jsonPath().getList("items", Employee.class);

        System.out.println("Number of employees = " + items.size());

        Employee firstEmlpoyee = items.get(0);
        System.out.println("firstEmlpoyee = " + firstEmlpoyee.getFirstName());
    }
}


//Student
//    String admissionNo
//    int batch
//    String birthDate
//    Company company
//    Contact contact
//    String firstName
//    String gender
//    String joinDate
//    String lastName
//    String major
//    String password
//    String section
//    int studentId
//    String subject
//
//
//Company
//     Address address
//     int companyId
//    String companyName
//    String startDate
//    String title
//
//Contact
//    int contactId
//    String emailAddress
//    String phone
//    String premanentAddress
//
//Address
//        int addressId;
//        String street;
//        String city;
//        String state;
//        int zipcode;
