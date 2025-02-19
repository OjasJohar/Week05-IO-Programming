package com.bridgelabz.advanced_problems.validate_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void validateCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read and print the header
            System.out.println(header);

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Invalid row (Missing columns): " + line);
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean isValidEmail = Pattern.matches(EMAIL_REGEX, email);
                boolean isValidPhone = Pattern.matches(PHONE_REGEX, phone);

                if (!isValidEmail) {
                    System.out.println("Invalid Email in row: " + line);
                }
                if (!isValidPhone) {
                    System.out.println("Invalid Phone Number in row: " + line);
                }

                if (isValidEmail && isValidPhone) {
                    System.out.println("Valid Record: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
