package com.bridgelabz.intermediate_problems.sort_csv;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class SortCSVTest {

    @Test
    public void testSortBySalary() throws IOException {
        String testFilePath = "src/main/resources/test_employee.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilePath))) {
            bw.write("ID,Name,Department,Salary\n");
            bw.write("E101,Ojas,IT,100000\n");
            bw.write("E102,Manish,HR,80000\n");
            bw.write("E103,Arpita,IT,60000\n");
            bw.write("E104,Om,Cloud Solutions,80000\n");
            bw.write("E105,Anush,Developer,90000\n");
            bw.write("E106,John,HR,95000\n");
            bw.write("E107,Sam,IT,110000\n");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        SortCSV.sortBySalary(testFilePath);

        String output = outputStream.toString();
        assertTrue(output.contains("Sam | Salary: 110000"));
        assertTrue(output.contains("Ojas | Salary: 100000"));
        assertTrue(output.contains("Anush | Salary: 90000"));
        assertTrue(output.contains("John | Salary: 95000"));
        assertTrue(output.contains("Manish | Salary: 80000"));

        new File(testFilePath).delete();
    }
}
