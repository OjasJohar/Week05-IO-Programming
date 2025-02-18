package com.bridgelabz.intermediate_problems.filter_records;

import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterRecordsTest {

    @Test
    public void testFilterRecords() throws IOException {
        String testFilePath = "src/main/resources/test_student.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilePath))) {
            bw.write("ID,Name,Age,Marks\n");
            bw.write("1,Ojas,22,90\n");
            bw.write("2,Manish,23,70\n");
            bw.write("3,Arpita,21,85\n");
            bw.write("4,Sejal,22,78\n");
        }

        List<String> filteredRecords = FilterRecords.filter(testFilePath);

        assertEquals(3, filteredRecords.size(), "Filtered records size should be 3");
        assertEquals("1,Ojas,22,90", filteredRecords.get(1), "First record should have marks 90");
        assertEquals("3,Arpita,21,85", filteredRecords.get(2), "Second record should have marks 85");

        new File(testFilePath).delete();
    }
}
