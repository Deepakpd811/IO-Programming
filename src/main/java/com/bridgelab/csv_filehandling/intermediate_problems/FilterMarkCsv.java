package com.bridgelab.csv_filehandling.intermediate_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterMarkCsv {

    public static void main(String[] args) {

        String filename = "studentMarks.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){

            br.readLine(); // skip header format
            String line;

            while((line= br.readLine())!=null){
                String[] data = line.split(",");
                // convert mark string to int
                int mark = Integer.parseInt(data[2]);

                if(mark > 80) {
                    System.out.println("ID: " + data[0] + " Name: " + data[1] + " Marks: " + data[2]) ;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
