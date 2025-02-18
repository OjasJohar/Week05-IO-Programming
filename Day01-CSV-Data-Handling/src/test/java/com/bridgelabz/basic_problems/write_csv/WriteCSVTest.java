package com.bridgelabz.basic_problems.write_csv;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WriteCSVTest {

    private static final String FILE_PATH = "src/main/resources/write_employee.csv";

    @Test
    public void testFileCreation() throws IOException {
        WriteCSV.writeData(FILE_PATH);

        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String header = reader.readLine();
        assertTrue(header.contains("ID, Name, Department, Salary"));

        String line = reader.readLine();
        assertTrue(line.contains("E101"));

        reader.close();
    }
}
