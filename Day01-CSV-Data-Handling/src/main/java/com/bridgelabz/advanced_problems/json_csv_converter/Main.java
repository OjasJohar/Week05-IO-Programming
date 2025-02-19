package com.bridgelabz.advanced_problems.json_csv_converter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Converting JSON to CSV...");
        JsonToCsvConverter.convertJsonToCsv();

        System.out.println("Converting CSV back to JSON...");
        CsvToJsonConverter.convertCsvToJson();
    }
}
