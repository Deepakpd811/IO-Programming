package com.bridgelab.csv_filehandling.advanced_problems.convert_csv_to_javaObjects;

public class Student {
    private String id;         // Unique ID
    private String name;       // Student's full name
    private int age;           // Age of the student

    // Constructor
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    // ✅ toString() - Print object in a readable format
    @Override
    public String toString() {
        return id + " | " + name + " | " + age;
    }

}
