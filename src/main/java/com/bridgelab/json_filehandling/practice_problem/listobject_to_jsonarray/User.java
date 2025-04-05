package com.bridgelab.json_filehandling.practice_problem.listobject_to_jsonarray;

public class User {

    private int id;
    private String name;
    private String email;
    private int age;

    User(int id, String name, String email, int age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
