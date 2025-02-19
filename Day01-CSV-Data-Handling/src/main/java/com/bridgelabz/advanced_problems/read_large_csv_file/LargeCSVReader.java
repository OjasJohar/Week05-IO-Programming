package com.bridgelabz.advanced_problems.read_large_csv_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LargeCSVReader {
        public static void readCSVInChunks(String filePath, int chunkSize) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String header = br.readLine();
                String line;
                int count = 0, batch = 1;

                while ((line = br.readLine()) != null) {
                    count++;


                     System.out.println(line);

                    if (count % chunkSize == 0) {
                        System.out.println("Processed batch " + batch + ": Records " + (count - chunkSize + 1) + " to " + count);
                        batch++;
                    }
                }

                if (count % chunkSize != 0) {
                    System.out.println("Processed batch " + batch + ": Records " + (count - (count % chunkSize) + 1) + " to " + count);
                }

                System.out.println("Total Records Processed: " + count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
