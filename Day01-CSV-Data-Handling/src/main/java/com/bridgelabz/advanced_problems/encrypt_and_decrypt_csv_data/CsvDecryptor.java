package com.bridgelabz.advanced_problems.encrypt_and_decrypt_csv_data;

import java.io.*;

public class CsvDecryptor {
    private static final String FILE_PATH = "src/main/resources/employees_encrypted.csv";

    public static void readDecryptedCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");

                if (emp[0].equals("ID")) {
                    System.out.println("ID: " + emp[0] + " | Name: " + emp[1] + " | Email: " + emp[2] + " | Salary: " + emp[3]);
                    continue;
                }

                String email = AESUtil.decrypt(emp[2]);
                String salary = AESUtil.decrypt(emp[3]);

                System.out.println("ID: " + emp[0] + " | Name: " + emp[1] + " | Email: " + email + " | Salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
