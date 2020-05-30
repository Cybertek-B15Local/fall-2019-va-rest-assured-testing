package com.cbt.tests.day8_more_serial;

import com.cbt.pojos.Character;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ThatHarryPotterQuestion {
    @Test
    public void getAllNames() {
        RestAssured.baseURI = "https://www.potterapi.com/v1/";
        JsonPath jsonPath = given().
                queryParam("key", "$2a$10$lFPOjM850JvpXGkyNazmK.k9pNCAnL0iyd9uVSIl4vI6OH1FQ0K0m").
                when().
                get("characters").prettyPeek().jsonPath();

        // name

        List<String> names = jsonPath.getList("name");
        System.out.println(names.size());
// map
        List<Map<String, ?>> people = jsonPath.getList("");
        System.out.println(people.size());
        System.out.println(people.get(0));

        // pojo
        List<Character> characters = jsonPath.getList("", Character.class);
        System.out.println(characters.get(0).getName());

        // then().body("", hasSize(195));  --> this is the winner
    }
}
