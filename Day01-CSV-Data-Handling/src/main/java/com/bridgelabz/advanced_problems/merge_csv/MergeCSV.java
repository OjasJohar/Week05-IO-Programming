package com.bridgelabz.advanced_problems.merge_csv;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {
    public static void mergeFiles(String file1, String file2, String outputFile) {
        Map<Integer, String[]> studentData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                studentData.put(id, new String[]{data[1].trim(), data[2].trim()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                if (studentData.containsKey(id)) {
                    String[] details = studentData.get(id);
                    bw.write(id + "," + details[0] + "," + details[1] + "," + data[1].trim() + "," + data[2].trim());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
