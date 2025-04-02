package com.bridgelab.csv_filehandling.advanced_problems.encryption_decryption_csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String key = "mykey";

    public static void encryptCSVData(String filename) {
        List<String[]> modifiedata = new ArrayList<>();

        // read the csv file and encript the password
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            List<String[]> data = reader.readAll();
            modifiedata.add(data.get(0));

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                row[2] = EncryptionDecryption.encrypt(row[2], key); // encrypt the password
                modifiedata.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // write the encrypt data to file
        try (CSVWriter writer = new CSVWriter(new FileWriter("encrypt" + filename))) {
            writer.writeAll(modifiedata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptCSVData(String encryptFilename) {
        List<String[]> modifiedata = new ArrayList<>();

        // read the csv file and encript the password
        try (CSVReader reader = new CSVReader(new FileReader(encryptFilename))) {
            List<String[]> data = reader.readAll();

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                row[2] = EncryptionDecryption.decrypt(row[2], key); // decrypt the password
                modifiedata.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        // write the encrypt data to file
        try (CSVWriter writer = new CSVWriter(new FileWriter("decrypt" + encryptFilename))) {
            writer.writeAll(modifiedata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "userdata.csv";
        String filename2 = "encrypt" + filename;

        // encrypt the csv file
        encryptCSVData(filename);

        // decrypt the csv file
        decryptCSVData(filename2);

    }
}
