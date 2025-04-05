package com.bridgelab.json_filehandling.practice_problem.listobject_to_jsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

public class ListObjectTojson {

    public static void main(String[] args) throws Exception{

        String filename = "files/users.json";

        ArrayList<User> listofuser= new ArrayList<>();

        listofuser.add(new User(101,"Deepak","demo@gmail.com",23));
        listofuser.add(new User(102,"Ritick","ritick@gmail.com",35));
        listofuser.add(new User(103,"Rohit","rohit@gmail.com",20));
        listofuser.add(new User(103,"Mohit","mohit@gmail.com",45));
        listofuser.add(new User(103,"Raj","raj@gmail.com",27));

        ObjectMapper objectMapper = new ObjectMapper();


        // convert list of object to json array string
        String jsonarray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listofuser);


        System.out.println(jsonarray);

    }
}
