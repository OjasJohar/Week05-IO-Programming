package com.bridgelabz.intermediate_problems.modify_csv;

import com.bridgelabz.intermediate_problems.search_record.SearchRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyRecordsTest {

    @Test
    public void testIncreaseSalary() throws IOException {
        String testFilePath = "src/main/resources/test_employee.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilePath))) {
            bw.write("ID,Name,Department,Salary\n");
            bw.write("E101,Ojas,IT,100000\n");
            bw.write("E102,Anush,HR,80000\n");
            bw.write("E103,Arpita,IT,60000\n");
            bw.write("E104,Om,Cloud Solutions,80000\n");
        }

        String targetDepartment = "IT";
        ModifyRecords.increaseSalary(testFilePath, targetDepartment);

        String[] employee1 = SearchRecord.searchByName(testFilePath, "Ojas");
        String[] employee2 = SearchRecord.searchByName(testFilePath, "Arpita");

        assertNotNull(employee1, "Employee Raj should be found");
        assertNotNull(employee2, "Employee Arpita should be found");

        int updatedSalaryRaj = Integer.parseInt(employee1[3].trim());
        int updatedSalaryArpita = Integer.parseInt(employee2[3].trim());

        assertEquals(110000, updatedSalaryRaj, "Ojas's salary should be increased by 10%");
        assertEquals(66000, updatedSalaryArpita, "Arpita's salary should be increased by 10%");

        new File(testFilePath).delete();
    }
}
