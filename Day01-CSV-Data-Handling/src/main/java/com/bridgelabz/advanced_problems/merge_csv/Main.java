package com.bridgelabz.advanced_problems.merge_csv;

public class Main {
    public static void main(String[] args) {
        String file1 = "src/main/resources/merge_1.csv";
        String file2 = "src/main/resources/merge_2.csv";
        String outputFile = "src/main/resources/merged_students.csv";

        MergeCSV.mergeFiles(file1, file2, outputFile);
        System.out.println("Merged CSV file created successfully!");
    }
}
