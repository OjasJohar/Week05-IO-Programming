package com.bridgelabz.basic_problems.write_csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void writeData(String filePath) {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath))){
            bw.write("ID, Name, Department, Salary\n");
            bw.write("E101, Ojas, IT, 100000\n");
            bw.write("E102, Anush, HR, 80000\n");
            bw.write("E103, Arpita, IT, 60000\n");
            bw.write("E104, Om, Cloud Solutions,80000\n");
            bw.write("E105, Raj, Developer, 90000\n");
            System.out.println("File successfully created!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
