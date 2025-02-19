package com.bridgelabz.intermediate_problems.filter_records;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/read_student.csv";
        List<String> arrayList=FilterRecords.filter(filePath);
        arrayList.forEach(System.out::println);
    }
}
