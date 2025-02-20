package com.bridgelabz.practice_problem_1.convert_java_objects_into_json_format;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {

    public static void convertingObjectToJson(){
        try {
            Car car = new Car("Toyota", "Corolla", 2023);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(car);

            System.out.println(jsonString);  // Output: {"brand":"Toyota","model":"Corolla","year":2023}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        convertingObjectToJson();
    }
}
