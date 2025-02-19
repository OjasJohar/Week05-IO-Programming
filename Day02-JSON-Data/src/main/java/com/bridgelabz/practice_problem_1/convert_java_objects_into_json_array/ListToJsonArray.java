package com.bridgelabz.practice_problem_1.convert_java_objects_into_json_array;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArray {

    public static void convertingListTojsonArray(List<?> list){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(list);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30)
        );
   convertingListTojsonArray(people);
    }
}
