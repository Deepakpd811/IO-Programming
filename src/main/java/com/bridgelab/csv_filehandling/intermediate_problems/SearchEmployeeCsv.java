package com.bridgelab.csv_filehandling.intermediate_problems;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class SearchEmployeeCsv {

    public static String searchEmployee(String filename, String searchName){

        StringBuilder sb = new StringBuilder();

        try (CSVReader reader = new CSVReader(new FileReader(filename))){
            // retrive the all data
            List<String[]> data = reader.readAll();

            // skip the header column
            for(int i=1; i<data.size(); i++){

                // search if searchName is present
                if(data.get(i)[0].equals(searchName)) {
                    sb.append("\nDepartment: " + data.get(i)[1] + "\nSalary: " + data.get(i)[2]);
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  sb.toString();
    }

    public static void main(String[] args) {

        String filename = "employee.csv";
        String name = "John Doe";

        String data = searchEmployee(filename,name);

        System.out.println("Name: " + name +" " + data);

    }
}
