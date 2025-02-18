package com.bridgelabz.intermediate_problems.search_record;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SearchRecordTest {

    @Test
    public void testSearchByName() throws IOException {
        String testFilePath = "src/main/resources/test_employee.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilePath))) {
            bw.write("ID,Name,Department,Salary\n");
            bw.write("E101,Raj,IT,100000\n");
            bw.write("E102,Ojas,HR,80000\n");
            bw.write("E103,Arpita,IT,60000\n");
            bw.write("E104,Om,Cloud Solutions,80000\n");
        }

        String target = "Ojas";
        String[] employee = SearchRecord.searchByName(testFilePath, target);

        assertNotNull(employee, "Employee record should be found");
        assertEquals("Ojas", employee[1].trim(), "Employee name should be Ojas");
        assertEquals("HR", employee[2].trim(), "Employee department should be HR");
        assertEquals("80000", employee[3].trim(), "Employee salary should be 80000");

        new File(testFilePath).delete();
    }
}
