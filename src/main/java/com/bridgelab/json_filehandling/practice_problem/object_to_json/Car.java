package com.bridgelab.json_filehandling.practice_problem.object_to_json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty("name")
    String name;
    @JsonProperty("model")
    String model;
    @JsonProperty("year")
    int year;

    Car(){

    }

    Car(String name, String model, int year) {
        this.name = name;
        this.model = model;
        this.year = year;
    }
}