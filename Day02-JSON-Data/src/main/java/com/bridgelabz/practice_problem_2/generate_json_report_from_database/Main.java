package com.bridgelabz.practice_problem_2.generate_json_report_from_database;

public class Main {
    public static void main(String[] args) {
        // Step 1: Fetch Employee Data from API
        String jsonResponse = EmployeeAPIClient.fetchEmployeeData();

        // Step 2: Generate JSON Report
        EmployeeJSONReportGenerator.generateReport(jsonResponse);
    }
}
