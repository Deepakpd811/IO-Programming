package com.bridgelab.csv_filehandling.advanced_problems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteDuplicateCsv {

    public static void deleteDuplicates(String filename) {

        List<String[]> duplicatesRow = new ArrayList<>();

        HashSet<Integer> hashSet = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {

            List<String[]> data = reader.readAll();

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                int id = Integer.parseInt(row[0].trim());

                if (hashSet.contains(id)) {
                    duplicatesRow.add(row);
                } else {
                    hashSet.add(id);
                }

            }

            if (duplicatesRow.isEmpty()) {
                System.out.println("No records is empty");

            } else {
                System.out.println("Duplicate records is found");
                for (String[] row : duplicatesRow) {
                    System.out.println("Id: " + row[0] + " Name: " + row[1] + " Age: " + row[2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filename = "students.csv";

        deleteDuplicates(filename);
    }
}
