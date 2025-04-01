package com.bridgelab.csv_filehandling.intermediate_problems;

import com.opencsv.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class UpdateCsv {
    public static void updateSalary(String filename, int percent) {

        try (CSVReader reader = new CSVReader(new FileReader(filename));
             CSVWriter writer = new CSVWriter(new FileWriter("update" + filename))
        ) {
            // Get all the data into a list of string array
            List<String[]> dataList = reader.readAll();

            for (int i = 1; i < dataList.size(); i++) {

                // get one data from list
                String[] data = dataList.get(i);

                if (data[1].trim().equalsIgnoreCase("IT")) {
                    Double getSalary = Double.parseDouble(dataList.get(i)[2]);
                    getSalary += getSalary * (percent / 100.0); // salary increased by  percent
                    data[2] = getSalary.toString();         // set the updated salary
                }

            }
            // update he modify value
            writer.writeAll(dataList);

            System.out.println("File Update Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        String filename = "employee.csv";
        updateSalary(filename, 10);

    }
}
