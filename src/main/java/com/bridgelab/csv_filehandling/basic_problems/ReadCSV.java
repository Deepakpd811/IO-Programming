package com.bridgelab.csv_filehandling.basic_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {

        String filename = "contact.csv";

        // try-resoures block for auto close resource
        // read the file with buffer reader
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {

                // split the line sting  by "," seperator
                String[] colums = line.split(",");

                // print the output
                System.out.print( colums[0] + " | " + colums[1] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
