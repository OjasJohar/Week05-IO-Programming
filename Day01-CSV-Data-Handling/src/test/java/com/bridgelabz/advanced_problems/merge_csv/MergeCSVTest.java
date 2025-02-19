package com.bridgelabz.advanced_problems.merge_csv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class MergeCSVTest {

    private Path tempFile1;
    private Path tempFile2;
    private Path tempOutputFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile1 = Files.createTempFile("merge_1", ".csv");
        tempFile2 = Files.createTempFile("merge_2", ".csv");
        tempOutputFile = Files.createTempFile("merged_students", ".csv");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile1)) {
            writer.write("ID,Name,Age\n");
            writer.write("1,John Doe,20\n");
            writer.write("2,Jane Smith,22\n");
            writer.write("3,Emily Johnson,19\n");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile2)) {
            writer.write("ID,Marks,Grade\n");
            writer.write("1,85.5,A\n");
            writer.write("2,90.0,B\n");
            writer.write("3,78.2,C\n");
        }
    }

    @Test
    void testMergeFiles() {
        MergeCSV.mergeFiles(tempFile1.toString(), tempFile2.toString(), tempOutputFile.toString());

        assertTrue(Files.exists(tempOutputFile), "Output file should be created");

        try (BufferedReader reader = Files.newBufferedReader(tempOutputFile)) {
            String line = reader.readLine();
            assertNotNull(line, "Header should not be null");
            assertEquals("ID,Name,Age,Marks,Grade", line, "Header is incorrect");

            line = reader.readLine();
            assertEquals("1,John Doe,20,85.5,A", line, "First row is incorrect");

            line = reader.readLine();
            assertEquals("2,Jane Smith,22,90.0,B", line, "Second row is incorrect");

            line = reader.readLine();
            assertEquals("3,Emily Johnson,19,78.2,C", line, "Third row is incorrect");
        } catch (IOException e) {
            fail("IOException occurred while reading the merged file: " + e.getMessage());
        }
    }
}
