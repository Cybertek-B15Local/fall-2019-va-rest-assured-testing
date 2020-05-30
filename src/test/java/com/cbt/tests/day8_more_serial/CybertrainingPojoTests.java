package com.cbt.tests.day8_more_serial;

import com.cbt.pojos.Student;
import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

@TestInstance(Lifecycle.PER_CLASS)
public class CybertrainingPojoTests {

    @BeforeAll
    public void setUp(){
        RestAssured.baseURI = ConfigurationReader.getProperty("training_base_url");
    }

    @Test
    public void getFirstStudentUsingJsonPath(){
        Response response = when().get("student/all").prettyPeek();
        response.then().statusCode(200).
                contentType(ContentType.JSON);

        Student student = response.jsonPath().getObject("students[0]", Student.class);
        System.out.println(student);

        // verify first name
        assertThat(student.getFirstName(), not(emptyOrNullString()));
//        response.then().body("students[0].firstName", not(emptyOrNullString()));

        // verify last name
        assertThat(student.getLastName(), not(emptyOrNullString()));
//        response.then().body("students[0].lastName", not(emptyOrNullString()));

        // verify gender
        assertThat(student.getGender(), not(emptyOrNullString()));
//        response.then().body("students[0].gender", not(emptyOrNullString()));
    }

}
