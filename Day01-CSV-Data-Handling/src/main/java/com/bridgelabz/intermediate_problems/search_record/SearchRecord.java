package com.bridgelabz.intermediate_problems.search_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static String[] searchByName(String filePath,String target) {
        try(BufferedReader bf=new BufferedReader(new FileReader(filePath))){
            String line;
            bf.readLine();
            while((line= bf.readLine())!=null){
                String [] data=line.split(",");
                if(matchName(data,target)){
                    return data;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static boolean matchName(String [] line, String target) {
        if(line[1].trim().equals(target)){
            return true;
        }
        return false;
    }
}
