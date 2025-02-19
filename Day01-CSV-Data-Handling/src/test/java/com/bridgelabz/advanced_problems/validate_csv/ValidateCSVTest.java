package com.bridgelabz.advanced_problems.validate_csv;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateCSVTest {

    @Test
    public void testValidateCSV() throws IOException {
        String testFilePath = "src/main/resources/test_validate_employee.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilePath))) {
            bw.write("ID,Name,Email,Phone\n");
            bw.write("E101,Raj,raj@example.com,9876543210\n");
            bw.write("E102,Manish,manish@example,123456789\n");
            bw.write("E103,Arpita,arpita@example.com,9988776655\n");
            bw.write("E104,Om,om@invalid-email,1122334455\n");
            bw.write("E105,Anush,anush@domain.com,1234567890\n");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        ValidateCSV.validateCSV(testFilePath);

        String output = outputStream.toString();
        assertTrue(output.contains("Valid Record: E101,Raj,raj@example.com,9876543210"));
        assertTrue(output.contains("Valid Record: E103,Arpita,arpita@example.com,9988776655"));
        assertTrue(output.contains("Valid Record: E105,Anush,anush@domain.com,1234567890"));

        new File(testFilePath).delete();
    }
}
