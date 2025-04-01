package com.bridgelab.csv_filehandling.advanced_problems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;
import java.io.FileReader;

public class ValidateCsv {

    public static void validateEmailsAndPhone(List<String[]> data) {

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        for (int i = 1; i < data.size(); i++) {
            String email = data.get(i)[3];
            String phoneNumber = data.get(i)[4];

            // email validataion
            if (!email.matches(regex)) {
                System.out.println((email + " Email is not valid on row number " + (i + 1)));
            }
            // ensure phoneNumber lenth must be 10
            if (phoneNumber.length() != 10 ) {
                System.out.println((phoneNumber + " Phone number length not valid on row number " + (i + 1)));
            }
        }

        System.out.println("No error ");

    }

    public static void main(String[] args) {

        String filename = "employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            // save data in list
            List<String[]> data = reader.readAll();

            //Validate emails and phone
            validateEmailsAndPhone(data);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (CsvException e) {
            System.out.println(e.getMessage());
        }

    }
}
