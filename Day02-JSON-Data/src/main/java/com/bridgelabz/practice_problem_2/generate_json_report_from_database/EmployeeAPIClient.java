package com.bridgelabz.practice_problem_2.generate_json_report_from_database;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class EmployeeAPIClient {
    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";

    public static String fetchEmployeeData() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            CloseableHttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
