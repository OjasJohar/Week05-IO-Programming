package com.bridgelabz.practice_problem_1.parse_json;

public class Person {
    public String name;
    public int age;

    // Default constructor (needed for Jackson)
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
