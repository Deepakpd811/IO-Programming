package com.bridgelab.json_filehandling.practice_problem.read_json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("name")
    String name;
    @JsonProperty("email")
    String email;
    @JsonProperty("age")
    int age;
    @JsonProperty("subject")
    String subject;

    Student(){

    }

    Student(String name, String email, int age,String subject) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.subject = subject;
    }
}
