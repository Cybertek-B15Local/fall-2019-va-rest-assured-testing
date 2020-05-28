package com.cbt.tests.day6_ssl_serialization_deserialization;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class SeriazlializationDeserializatonExample {

    // read the file
    @Test
    public void readToMap() throws FileNotFoundException {
        // this will read the file
        FileReader fileReader = new FileReader("src/test/resources/car.json");

        // convert the file into object that we can use more easily
       // let's create a map from this
       // we do the conversion using Gson or Jackson-databind
        // in out framework we use Gson
        // json --> file type (like xml, pdf, doc)
        // gson --> library used for conversion(serizliation and deserizliation)
        // Jason --> name  but that is not importatn right now
        Gson gson = new Gson();

        // we converted the file into a map
        // we deserialized file to java object
        Map<String, ?> myCar = gson.fromJson(fileReader, Map.class);
        System.out.println(myCar);
        System.out.println(myCar.get("doors"));
        System.out.println(myCar.get("make"));

    }

    @Test
    public void readToObject(){

    }

}
