package com.bridgelab.csv_filehandling.basic_problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    public static void main(String[] args) {

        String filename ="contact.csv";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {

            bw.write("name,PhoneNumber\n");
            bw.write("Deepak,8974513645\n");
            bw.write("Ritick,700547895\n");
            bw.write("Rohit,7511875378\n");

            System.out.println("Write successfully");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
