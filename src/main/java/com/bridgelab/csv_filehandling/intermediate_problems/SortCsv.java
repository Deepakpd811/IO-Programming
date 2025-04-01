package com.bridgelab.csv_filehandling.intermediate_problems;

import com.opencsv.CSVReader;
import java.util.List;
import java.io.FileReader;

import java.util.Comparator;

public class SortCsv {

    // Method to sort the data
    public static void sortData(List<String[]> data){
        data.sort(Comparator.comparingDouble(record -> -Double.parseDouble(record[2].trim())));
    }
    // method to print he hightst salary
    public static void printHighestSalary(List<String[]> list,int n){

        for(int i=0; i<Math.min(5,list.size()); i++){
            System.out.println(list.get(i)[0] +" | " +  list.get(i)[1] + " | "+list.get(i)[2]);
        }

    }

    public static void main(String[] args) {

        String filename = "employees.csv";

        // read the file using openCsv
        try(CSVReader reader = new CSVReader(new FileReader(filename))){
            // get all the data
            List<String[]> data = reader.readAll();
            //remove the first Header line
            data.removeFirst();
            // Sort the data
            sortData(data);

            // print 5 highest salary employee
            printHighestSalary(data,5);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
