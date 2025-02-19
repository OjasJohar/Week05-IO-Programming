package com.bridgelabz.advanced_problems.detect_duplicates_in_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectDuplicates {
    public static void findDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println("Detecting Duplicates...");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();

                if (!uniqueIds.add(id)) {
                    duplicates.add(line);
                }
            }

            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicates) {
                    System.out.println(record);
                }
            } else {
                System.out.println("No Duplicates Found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
