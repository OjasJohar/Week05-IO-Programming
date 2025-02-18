package com.bridgelabz.advanced_problems.convert_csv_to_object;

public class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }


    @Override
    public String toString() {
        return "Student { " +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                " }";
    }
}

