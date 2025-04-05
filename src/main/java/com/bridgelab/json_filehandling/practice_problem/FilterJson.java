package com.bridgelab.json_filehandling.practice_problem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class FilterJson {

    public static void filterData(String filepath) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.readTree(new File(filepath));

            // create list to store filter data
            ArrayList<JsonNode> jsonList = new ArrayList<>();

            // filter the json with json node tree
            for (int i = 0; i < jsonNode.size(); i++) {
                if (jsonNode.get(i).get("age").asInt() > 25) {
                    jsonList.add(jsonNode.get(i));
                }
            }

            //print the json filter data as string
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        String filepath = "files/users.json";

        // filter the data age greater than 25
        filterData(filepath);


    }
}
