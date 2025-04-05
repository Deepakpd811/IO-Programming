package com.bridgelab.json_filehandling.ipl_censorship_rule;

public class Main {
    public static void main(String[] args) {
        String filepathjson = "files/json/ipl_data.json";
        String filepathcsv = "files/csv/ipl_data.csv";

        // Censor json file
        IplCensor.iplCensorJson(filepathjson);

        // Censor csv file
        IplCensor.iplCensorCsv(filepathcsv);

    }
}
