package com.bridgelab.json_filehandling.handonpractice.csv_to_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXml {

    public static void main(String[] args) throws IOException {

        // read json
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(new File("input.json"));

        // convert to xml
        XmlMapper xmlMapper = new XmlMapper();
        String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // print the output
        System.out.println(xmlOutput);
        xmlMapper.writeValue(new File("output.xml"), jsonNode);
    }

}
