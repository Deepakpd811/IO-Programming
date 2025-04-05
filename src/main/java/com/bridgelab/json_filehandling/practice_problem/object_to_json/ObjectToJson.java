package com.bridgelab.json_filehandling.practice_problem.object_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class ObjectToJson {

    public static void objectTOJson(String filename, Object obj) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            // serializing
            // convert java object into car.json file
            objectMapper.writeValue(new File(filename), obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("conversion complete. ");
    }

    public static void main(String[] args) {

        String filename = "files/car.json";

        Car car = new Car("Bmw", "AB123", 2020);
        // serialization
        objectTOJson(filename, car);
    }
}
