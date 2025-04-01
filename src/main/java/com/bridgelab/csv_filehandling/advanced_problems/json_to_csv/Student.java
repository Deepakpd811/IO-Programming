package com.bridgelab.csv_filehandling.advanced_problems.json_to_csv;

public class Student {

    private String id;
    private String name;
    private int age;


    // Default constructor (for Jackson)
    public Student() {
        // Default constructor is required for Jackson deserialization
    }

    // Parameterized constructor
    public Student(String id, String name, int age ) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age=" + age;
    }
}
