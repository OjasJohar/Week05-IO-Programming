package com.bridgelabz.practice_problem_2.convert_java_objects_into_json_array;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters are required for serialization
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
