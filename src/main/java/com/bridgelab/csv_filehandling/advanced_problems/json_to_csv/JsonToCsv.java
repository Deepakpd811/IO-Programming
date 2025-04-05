package com.bridgelab.csv_filehandling.advanced_problems.json_to_csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonToCsv {

    public static void convertJsonToCsv(String jsonFileName, String csvFileName) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Deserialize the JSON file into a List of Student objects
            Student students = objectMapper.readValue(new File(jsonFileName), Student.class);

            // Write the List of students to the CSV file
            writeToCsv(students, csvFileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToCsv(Student stud, String csvFileName) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFileName))) {
            // Write header
            String[] header = {"ID", "Name", "Age"};
            writer.writeNext(header);

            // Write student data
            String[] data = {stud.getId(), stud.getName(), String.valueOf(stud.getAge())};
            writer.writeNext(data); // Write student's record in csv

            System.out.println("Write successfull");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static void convertCsvTojson(String csvfilename, String jsonfile) {

        try (CSVReader reader = new CSVReader(new FileReader(csvfilename));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonfile))) {

            List<Student> students = new ArrayList<>();

            List<String[]> data = reader.readAll();

            ObjectMapper objectMapper = new ObjectMapper();

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                Student student = new Student(row[0], row[1], Integer.parseInt(row[2]));
                students.add(student);
            }

            String jsonoutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);

            bw.write(jsonoutput);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        String jsonFileName = "student.json";
        String csvFileName = "newstudents.csv";

        //Convert json file to csv file
        convertJsonToCsv(jsonFileName, csvFileName);
        String outputjson = "outjson.json";

        convertCsvTojson(csvFileName, outputjson);

    }
}
