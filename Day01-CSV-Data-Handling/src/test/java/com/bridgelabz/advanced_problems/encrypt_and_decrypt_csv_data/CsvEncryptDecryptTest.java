package com.bridgelabz.advanced_problems.encrypt_and_decrypt_csv_data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class CsvEncryptDecryptTest {

    private static final String ENCRYPTED_FILE_PATH = "src/main/resources/employees_encrypted.csv";
    private static final String EXPECTED_CSV_CONTENT = "ID,Name,Email,Salary\n" +
            "101,Raj,ZGVtby1yYWplbm15QGV4YW1wbGUuY29t,ZTgwMDA=\n" +
            "102,Ojas,ZGVtby1tYW5pc2hAYGVtYWlsLmNvbQ==,NTMwMDA=\n" +
            "103,Arpita,ZGVtby1hcnBpdGFAZXhhbXBsZS5jb20sNjAwMA==,NzgwMDA=\n";

    @BeforeEach
    void setUp() {
        deleteFile(ENCRYPTED_FILE_PATH);
    }

    private void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testEncryptAndWriteCsv() {
        CsvEncryptor.writeEncryptedCsv();

        File encryptedFile = new File(ENCRYPTED_FILE_PATH);
        assertTrue(encryptedFile.exists(), "Encrypted file should be created");

        try (BufferedReader reader = new BufferedReader(new FileReader(encryptedFile))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            fail("IOException occurred while reading the encrypted CSV file: " + e.getMessage());
        }
    }

    @Test
    void testDecryptAndReadCsv() {
        CsvEncryptor.writeEncryptedCsv();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        CsvDecryptor.readDecryptedCsv();

        String expectedOutput = "ID: 101 | Name: Raj | Email: demo-raj@example.com | Salary: 80000\n" +
                "ID: 102 | Name: Ojas | Email: demo-ojas@email.com | Salary: 53000\n" +
                "ID: 103 | Name: Arpita | Email: demo-arpita@example.com | Salary: 78000\n";

    }
}
