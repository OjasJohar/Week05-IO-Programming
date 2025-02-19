package com.bridgelabz.basic_problems.read_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void giveInfo(String path) {
        try(BufferedReader bf=new BufferedReader(new FileReader(path))){
            String line;
            bf.readLine();
            while((line= bf.readLine())!=null){
                String [] columns=line.split(",");
                System.out.println("ID : "+columns[0]+" | Name : "+columns[1]+" | Age : "+columns[2]+" | Marks : "+columns[3]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
