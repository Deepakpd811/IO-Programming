package com.bridgelab.json_filehandling.ipl_censorship_rule;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IplCensor {

    public static String censorString(String str) {
        String[] parts = str.split(" ");
        return parts[0] + " *** ";
    }

    public static void iplCensorCsv(String filepath) {
        String outfileName = "files/csv/ipl_censor.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {

            List<String[]> data = reader.readAll();
            List<String[]> output = new ArrayList<>();

            output.add(data.getFirst());

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);

                row[1] = censorString(row[1]);
                row[2] = censorString(row[2]);
                row[5] = censorString(row[5]);
                row[6] = "REDACTED";

                output.add(row);
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(outfileName))){
                writer.writeAll(output);
            }

            System.out.println("Censor file of csv complete ");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void iplCensorJson(String filepath) {

        String outfileName = "files/json/ipl_censor.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            // get arraynode
            JsonNode arrayNode = objectMapper.readTree(new File(filepath));

            for (JsonNode node : arrayNode) {

                // get one json object in object node
                ObjectNode obj = (ObjectNode) node;

                // update the field with censoring-rule
                obj.put("team1", censorString(obj.get("team1").asText()));
                obj.put("team2", censorString(obj.get("team2").asText()));
                obj.put("player_of_match", "REDACTED");
                obj.put("winner", censorString(obj.get("winner").asText()));

                // get the score node which is nested node in one object node
                ObjectNode scoreNode = (ObjectNode) obj.get("score");

                // create new score objectNode
                ObjectNode newScore = objectMapper.createObjectNode();

                // get the fields of score node
                Iterator<String> key = scoreNode.fieldNames();

                // iterate and update the filed name with censor-rule
                while (key.hasNext()) {
                    String teamField = key.next();
                    int score = scoreNode.get(teamField).asInt();
                    newScore.put(censorString(teamField), score); // update new score
                }

                obj.set("score", newScore); // update the Object node

            }

            // convert to json file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outfileName), arrayNode);

            System.out.println("Censor of json file complete ");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
