package com.bridgelab.csv_filehandling.basic_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsCSV {
    public static void main(String[] args) {

        String filename = "contact.csv";

        // try-resources block for auto close resource
        // read the file with buffer reader
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            int count =0;
            while ((line = br.readLine()) != null) {
                br.readLine(); // excluding the header

                // split the line sting  by "," seperator
                String[] column = line.split(",");

                // print the output
                System.out.print( column[0] + " | "+column[1] + "\n");
                count++;
            }
            System.out.println("Number of records: " + count);
        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
