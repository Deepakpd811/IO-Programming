package com.bridgelab.json_filehandling.practice_problem.validate_json;

public class Main {

    public static void main(String[] args) throws Exception{

        String schemaFilePath = "files/userSchema.json";
        String userFilePath = "files/user.json";

        // validate the file
        boolean userValidate = SchemaValidation.validate(schemaFilePath,userFilePath);

        if(userValidate){
            System.out.println("User json file is valid");
        }else{
            System.out.println("User json file is not  valid");

        }


    }

}
