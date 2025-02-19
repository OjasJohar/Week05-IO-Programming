package com.bridgelabz.advanced_problems.read_large_csv_file;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large_data.csv";  //could not push large file to git as it was more than 500mb
        int chunkSize = 100;
        LargeCSVReader.readCSVInChunks(filePath, chunkSize);
    }
}
