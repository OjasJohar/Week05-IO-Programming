package com.bridgelabz.basic_problems.read_csv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.*;

class ReadCSVTest {
    private Path tempFile;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() throws IOException {
        // Redirect console output
        System.setOut(new PrintStream(outputStream));

        // Create a temporary CSV file
        tempFile = Files.createTempFile("test_students", ".csv");
        String csvData = "ID,Name,Age,Marks\n" +
                "1,Ojas,21,85\n" +
                "2,Anush,22,78\n";
        Files.write(tempFile, csvData.getBytes(), StandardOpenOption.WRITE);
    }

    @AfterEach
    void tearDown() throws IOException {
        System.setOut(originalOut);

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testGiveInfo() {
        ReadCSV.giveInfo(tempFile.toString());

        String expectedOutput = "ID : 1 | Name : Ojas | Age : 21 | Marks : 85\n" +
                "ID : 2 | Name : Anush | Age : 22 | Marks : 78\n";

        assertEquals(expectedOutput, outputStream.toString().replace("\r", ""));
    }
}
