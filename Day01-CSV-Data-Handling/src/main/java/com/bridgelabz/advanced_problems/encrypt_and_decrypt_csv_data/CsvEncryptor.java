package com.bridgelabz.advanced_problems.encrypt_and_decrypt_csv_data;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CsvEncryptor {
    private static final String FILE_PATH = "src/main/resources/employees_encrypted.csv";

    public static void writeEncryptedCsv() {
        List<String[]> employees = Arrays.asList(
                new String[]{"ID", "Name", "Email", "Salary"},
                new String[]{"101", "Raj", "raj@example.com", "50000"},
                new String[]{"102", "Ojas", "ojas@example.com", "60000"},
                new String[]{"103", "Arpita", "arpita@example.com", "70000"}
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String[] emp : employees) {
                String email = emp[0].equals("ID") ? emp[2] : AESUtil.encrypt(emp[2]);
                String salary = emp[0].equals("ID") ? emp[3] : AESUtil.encrypt(emp[3]);

                writer.write(emp[0] + "," + emp[1] + "," + email + "," + salary);
                writer.newLine();
            }
            System.out.println("Encrypted CSV written successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
