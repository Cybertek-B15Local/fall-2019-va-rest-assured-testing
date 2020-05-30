package com.cbt.tests.day8_more_serial;

import com.cbt.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CybertrainingPojoTests {

    @BeforeAll
    public void setUp(){
        RestAssured.baseURI = ConfigurationReader.getProperty("training_base_url");
    }

    @Test
    public void getFirstStudentUsingJsonPath(){

    }
}
