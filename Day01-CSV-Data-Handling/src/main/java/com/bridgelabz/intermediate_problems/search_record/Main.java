package com.bridgelabz.intermediate_problems.search_record;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/write_employee.csv";
        String target="Ojas";
        String [] employee=SearchRecord.searchByName(filePath,target);
        if(!(employee==null)){
            System.out.println("Name : "+employee[1].trim()+" | Department : "+employee[2].trim()+" | Salary : "+employee[3].trim());
        }else{
            System.out.println("Record Not Found!");
        }
    }
}
