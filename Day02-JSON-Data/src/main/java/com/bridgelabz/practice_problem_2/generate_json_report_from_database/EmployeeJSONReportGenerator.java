package com.bridgelabz.practice_problem_2.generate_json_report_from_database;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeJSONReportGenerator {
    private static final String JSON_FILE_PATH = "src/main/resources/employee_report.json";

    public static void generateReport(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.isEmpty()) {
            System.out.println("Error: API response is empty.");
            return;
        }

        JSONArray employees = new JSONArray(jsonResponse);
        JSONArray reportData = new JSONArray();

        for (int i = 0; i < employees.length(); i++) {
            JSONObject emp = employees.getJSONObject(i);
            JSONObject report = new JSONObject();

            report.put("ID", emp.getInt("id"));
            report.put("Name", emp.getString("name"));
            report.put("Email", emp.getString("email"));
            report.put("City", emp.getJSONObject("address").getString("city"));
            report.put("Company", emp.getJSONObject("company").getString("name"));

            reportData.put(report);
        }

        try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
            file.write(reportData.toString(4)); // Pretty-print JSON
            System.out.println("JSON Report generated successfully: " + JSON_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
