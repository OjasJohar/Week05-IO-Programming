package com.bridgelabz.advanced_problems.read_large_csv_file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class LargeCSVReaderTest {

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("large_data", ".csv");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("ID,Name,Age\n");
            for (int i = 1; i <= 300; i++) {
                writer.write(i + ",Name" + i + "," + (20 + i % 5) + "\n");
            }
        }
    }

    @Test
    void testReadCSVInChunks() {
        assertTrue(Files.exists(tempFile), "Test file should exist");

        LargeCSVReader.readCSVInChunks(tempFile.toString(), 100);

        try (BufferedReader reader = Files.newBufferedReader(tempFile)) {
            String line;
            int recordCount = 0;

            while ((line = reader.readLine()) != null) {
                recordCount++;
            }

            assertEquals(301, recordCount, "File should contain 301 records (including header)");
        } catch (IOException e) {
            fail("IOException occurred while reading the test file: " + e.getMessage());
        }
    }
}
