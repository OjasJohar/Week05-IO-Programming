package com.bridgelabz.advanced_problems.generate_csv_from_database;

public class Main {
    public static void main(String[] args) {
        String jsonResponse = EmployeeAPIClient.fetchEmployeeData();

        EmployeeCSVWriter.writeEmployeeDataToCSV(jsonResponse);
    }
}
