package com.bridgelabz.advanced_problems.generate_csv_from_database;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class EmployeeCSVWriter {
    private static final String CSV_FILE_PATH = "src/main/resources/database_employees.csv";
    private static final String[] DEPARTMENTS = {"HR", "Finance", "IT", "Sales", "Marketing", "Operations"}; // Random departments
    private static final Random RANDOM = new Random();

    public static void writeEmployeeDataToCSV(String jsonResponse) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            JSONArray employees = new JSONArray(jsonResponse);

            writer.write("Employee ID, Name, Department, Salary\n");

            for (int i = 0; i < employees.length(); i++) {
                JSONObject emp = employees.getJSONObject(i);

                int id = emp.getInt("id");
                String name = emp.getString("name");
                String department = DEPARTMENTS[RANDOM.nextInt(DEPARTMENTS.length)];
                int salary = 50000 + RANDOM.nextInt(50000);

                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV file generated successfully: " + CSV_FILE_PATH);

        } catch (IOException | org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
