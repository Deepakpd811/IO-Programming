package com.bridgelab.csv_filehandling.advanced_problems.convert_csv_to_javaObjects;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConvertCsvToObject {

    //Reads a CSV file and converts it into a list of Student objects
    public static List<Student> loadStudentsFromCSV(String filename) {
        List<Student> students = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filename))) {

            List<String[]> data = reader.readAll(); // Read all rows at once

            for(int i=1; i<data.size(); i++){ // skip header row
                Student student = parseStudent(data.get(i));
                students.add(student);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    // parse the row into a student object
    public static Student parseStudent(String[] row){
        String id = row[0];
        String name = row[1];
        int age = Integer.parseInt(row[2]);
        return new Student(id,name,age);
    }


    public static void main(String[] args) {

        String filePath = "students.csv"; // Change to your actual CSV file path

        // Load students from CSV
        List<Student> students = loadStudentsFromCSV(filePath);

        // Print the student list
        for(Student stud: students){
            System.out.println("Id: "+ stud.getId());
            System.out.println("Name: "+ stud.getName());
            System.out.println("Age: "+ stud.getAge() + "\n");
        }

    }
}
