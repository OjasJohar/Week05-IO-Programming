package com.bridgelabz.advanced_problems.detect_duplicates_in_csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class DetectDuplicatesTest {

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("duplicate_student", ".csv");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("ID,Name,Age\n");
            writer.write("1,John,20\n");
            writer.write("2,Jane,22\n");
            writer.write("3,Jim,24\n");
            writer.write("1,John,20\n");
            writer.write("4,Jack,25\n");
        }
    }

    @Test
    void testFindDuplicates() {
        DetectDuplicates.findDuplicates(tempFile.toString());

        assertTrue(Files.exists(tempFile), "Test file should exist");

        try (BufferedReader reader = Files.newBufferedReader(tempFile)) {
            String line;
            int recordCount = 0;

            while ((line = reader.readLine()) != null) {
                recordCount++;
            }

            assertEquals(6, recordCount, "File should contain 6 records (including header)");
        } catch (IOException e) {
            fail("IOException occurred while reading the test file: " + e.getMessage());
        }
    }
}
