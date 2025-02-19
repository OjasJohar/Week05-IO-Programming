package com.bridgelabz.intermediate_problems.modify_csv;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/write_employee.csv";
        String targetDepartment="IT";
        ModifyRecords.increaseSalary(filePath,targetDepartment);
    }
}
