package com.bridgelab.json_filehandling.handonpractice.csv_to_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJson {

    public static void read(String filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // read json which is an arrayNode
        JsonNode jsonNode = objectMapper.readTree(new File(filepath));


        for (JsonNode employee : jsonNode) {

            // Gets the fields of one Object
            System.out.println("Employee:");
            Iterator<Map.Entry<String, JsonNode>> fields = employee.fields();

            // iterator each fields and print
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println("  " + field.getKey() + " : " + field.getValue().asText());
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {

        String filepath = "files/employees.json";

        try {
            // read the file
            read(filepath);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
