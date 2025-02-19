package com.bridgelabz.basic_problems.count_rows;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/row_count.csv";
        int count=CountRows.count(filePath);
        System.out.println("Number of rows in file is : "+count);
    }
}
