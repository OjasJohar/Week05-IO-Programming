package com.bridgelabz.intermediate_problems.filter_records;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterRecords {
    public static List<String> filter(String filePath) {
        List<String> result=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(filePath))){
            result.add(bf.readLine());
            String line;
            while((line= bf.readLine())!=null){
                String [] data=line.split(",");
                if(checkMarks(data)){
                    result.add(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    private static boolean checkMarks(String[] data) {
        int marks=Integer.parseInt(data[3]);
        if(marks>80){
            return true;
        }
        return false;
    }
}
