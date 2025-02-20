package com.bridgelabz.practice_problem_1.convert_java_objects_into_json_format;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (needed for Jackson)
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
