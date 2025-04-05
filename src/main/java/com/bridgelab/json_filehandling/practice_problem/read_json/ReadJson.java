package com.bridgelab.json_filehandling.practice_problem.read_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJson {

    public static void  readJson(String filepath){

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            // read json from file
            // NOTE:  json file contain one json object not array of object
            Student student = objectMapper.readValue(new File(filepath),Student.class);

            System.out.println("Name: " +student.name + " Email: " + student.email);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
