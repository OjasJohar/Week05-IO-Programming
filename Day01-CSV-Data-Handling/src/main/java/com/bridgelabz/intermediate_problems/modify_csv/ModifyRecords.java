package com.bridgelabz.intermediate_problems.modify_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyRecords {

    public static void increaseSalary(String filePath,String target) {
        List<String>records=new ArrayList<>();
        boolean isUpdated=false;

        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();
            records.add(line);
            while((line=br.readLine())!=null){
                String [] data=line.split(",");
                if(data[2].trim().equalsIgnoreCase(target)){
                    int salary=Integer.parseInt(data[3].trim());
                    data[3]=String.valueOf(salary+salary/10);
                    isUpdated=true;
                }
                records.add(String.join(",",data));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        if(isUpdated){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (String record : records) {
                    bw.write(record);
                    bw.newLine();
                }
                System.out.println("Salary updated successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Employee not found!");
        }

    }
}
