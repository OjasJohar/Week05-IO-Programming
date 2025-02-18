package com.bridgelabz.basic_problems.count_rows;

import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountRowsTest {

    @Test
    public void testCountRows() throws IOException {
        String testFilePath = "src/main/resources/test_row_count.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilePath))) {
            bw.write("ID,Name,Age,Marks\n");
            bw.write("1,Ojas,25,90\n");
            bw.write("2,johar,28,85\n");
        }

        int count = CountRows.count(testFilePath);
        assertEquals(2, count, "Row count should exclude the header");


        new File(testFilePath).delete();
    }
}
