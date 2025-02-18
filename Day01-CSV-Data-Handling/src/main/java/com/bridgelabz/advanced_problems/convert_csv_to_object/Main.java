package com.bridgelabz.advanced_problems.convert_csv_to_object;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/read_student.csv";
        List<Student> students = CSVToStudentList.readCSV(filePath);

        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
