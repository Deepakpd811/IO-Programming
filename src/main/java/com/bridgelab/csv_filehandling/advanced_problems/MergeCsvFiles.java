package com.bridgelab.csv_filehandling.advanced_problems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeCsvFiles {

    // Write merged data into a new CSV file
    private static void writeCSV(Map<String, String[]> dataMap, String outputFile) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            // Write header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            // Write merged data
            for (String[] row : dataMap.values()) {
                writer.writeNext(row);
            }
        }
    }

    private static Map<String, String[]> readCSV(String file1) {

        Map<String,String[]> mapData = new HashMap<>();

        try(CSVReader reader = new CSVReader(new FileReader(file1))){

            List<String[]> data = reader.readAll();  // get all data from csv

            for(int i=1; i<data.size(); i++){ // skip header
                mapData.put(data.get(i)[0], data.get(i));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  mapData;
    };

    private static void mergeCSV(Map<String, String[]> studentData, String file2) {

        try(CSVReader reader = new CSVReader(new FileReader(file2))){

            List<String[]> data = reader.readAll();  // get all data from csv

            for(int i=1; i<data.size(); i++){ // skip header
                String[] file2data = data.get(i);
                String id =file2data[0];
                if(studentData.containsKey(data.get(i)[0])){  // id
                    String[] file1data = studentData.get(id);
                    String[] mergedata = {file1data[0],file1data[1],file1data[2], file2data[1], file2data[2]};
                    studentData.put(id,mergedata);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file1 = "students.csv"; // Contains ID, Name, Age
        String file2 = "students1.csv"; // Contains ID, Marks, Grade
        String outputFile = "merged_students.csv"; // Merged output file

        try {
            // Read first CSV file (ID, Name, Age) and store in a HashMap
            Map<String, String[]> studentData = readCSV(file1);

            // Read second CSV file (ID, Marks, Grade) and merge with existing data
            mergeCSV(studentData, file2);

            // Write the merged data to a new CSV file
            writeCSV(studentData, outputFile);

            System.out.println(" Merged file created successfully: " + outputFile);
        } catch (IOException  e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}

