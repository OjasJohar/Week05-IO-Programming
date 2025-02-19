package com.bridgelabz.basic_problems.count_rows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static int count(String filePath) {
        int count=0;
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            while (br.readLine()!=null) {
                count++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return count-1;
    }
}
