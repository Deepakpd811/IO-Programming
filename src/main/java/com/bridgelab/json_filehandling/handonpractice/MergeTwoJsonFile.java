package com.bridgelab.json_filehandling.handonpractice.csv_to_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeTwoJsonFile {


    public static void merge(String file1, String file2) throws IOException {

        String outfile = "files/json/merge.json";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode file1Node = objectMapper.readTree(new File(file1));
        JsonNode file2Node = objectMapper.readTree(new File(file2));

        ObjectNode mergeNode = objectMapper.createObjectNode();

        mergeNode.setAll((ObjectNode) file1Node);
        mergeNode.setAll((ObjectNode) file2Node);

        String ans = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergeNode);

        System.out.println("Merge is successfull" );
        System.out.println(ans);

    }


    public static void main(String[] args) throws IOException {

        String file1 = "files/user.json";
        String file2 = "files/userBank.json";

        merge(file1,file2);

    }

}
