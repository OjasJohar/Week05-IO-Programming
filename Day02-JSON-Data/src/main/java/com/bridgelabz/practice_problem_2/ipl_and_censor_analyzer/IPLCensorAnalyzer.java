package com.bridgelabz.practice_problem_2.ipl_and_censor_analyzer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.opencsv.*;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvException;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            List<IPLMatch> matches = readJson("src/main/resources/ipl_data.json");
            writeJson(censorData(matches), "src/main/resources/ipl_censored.json");

            List<String[]> csvMatches = readCsv("src/main/resources/ipl_data.csv");
            writeCsv(censorCsvData(csvMatches), "src/main/resources/ipl_censored.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<IPLMatch> readJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<IPLMatch>>() {});
    }

    private static void writeJson(List<IPLMatch> matches, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }

    private static List<String[]> readCsv(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().build()) // Ignore empty lines
                .build()) {
            return reader.readAll();
        }
    }


    private static void writeCsv(List<String[]> data, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(data);
        }
    }

    public static List<IPLMatch> censorData(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.team1 = censorTeamName(match.team1);
            match.team2 = censorTeamName(match.team2);
            match.winner = censorTeamName(match.winner);
            match.player_of_match = "REDACTED";
        }
        return matches;
    }

    public static List<String[]> censorCsvData(List<String[]> data) {
        List<String[]> filteredData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String[] row = data.get(i);

            // Skip empty rows
            if (row.length == 0 || (row.length == 1 && row[0].trim().isEmpty())) {
                System.err.println("Skipping empty row at index: " + i);
                continue;
            }

            // Ensure valid row structure
            if (row.length < 7) {
                System.err.println("Skipping malformed row: " + Arrays.toString(row));
                continue;
            }

            row[1] = censorTeamName(row[1]); // Censor team1
            row[2] = censorTeamName(row[2]); // Censor team2
            row[5] = censorTeamName(row[5]); // Censor winner
            row[6] = "REDACTED"; // Censor player_of_match

            filteredData.add(row); // Add only valid rows
        }

        return filteredData;
    }



    public static String censorTeamName(String teamName) {
        if (teamName.contains(" ")) {
            String[] parts = teamName.split(" ", 2);
            return parts[0] + " ***";
        }
        return teamName;
    }
}
