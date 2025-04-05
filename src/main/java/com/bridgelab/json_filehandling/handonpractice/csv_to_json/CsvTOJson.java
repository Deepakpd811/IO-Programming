package com.bridgelab.json_filehandling.handonpractice.csv_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvTOJson {

    public static void convertCsvToJson(String csvPath, String outputPath) throws IOException , CsvException {

        try(CSVReader reader = new CSVReader(new FileReader(csvPath))){

            List<String[]> csvData  = reader.readAll();

            List<Map<String,String>> mapjson = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();

            // get the header in string array
            String[] header = csvData.getFirst();


            for(int i=1; i<csvData.size(); i++){

                // Create a HashMap to hold key-value pairs for this row
                HashMap<String,String > hs = new LinkedHashMap<>();

                // For each column in the row, map it with its corresponding header
                for(int j=0; j<csvData.get(i).length; j++){
                    hs.put(header[j],csvData.get(i)[j]);
                }
                // Add the row in the map
                mapjson.add(hs);
            }

            //convert map to json
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), mapjson);

        }

    }

    public static void main(String[] args)  {

        String csvFilePath = "files/csv/employees.csv";
        String jsonOutputPath = "files/json/employees.json";

        try{
            // parse csv to json
            convertCsvToJson(csvFilePath,jsonOutputPath);

        } catch (Exception e) {
            System.out.println("Error occour: " + e.getMessage());
        }

    }
}
