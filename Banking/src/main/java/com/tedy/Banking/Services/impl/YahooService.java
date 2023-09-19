package com.tedy.Banking.Services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet; // Add this import
import java.util.Iterator;

@Service
public class YahooService {

    @Value("${yahoo.api.url}")
    private String apiUrl;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DataSource dataSource;


    public void fetchAndInsertDataFromYahoo(String extractedValue) {
        try {
            String sapiUrl = apiUrl + "?symbol=TSLA"+ "&region=US";

            System.out.println(sapiUrl);

            // Perform the Yahoo API request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(sapiUrl))
                    .header("X-RapidAPI-Key", "5ce3259baamsh927e932246a4b9bp13b280jsne1e7b7bc0238")
                    .header("X-RapidAPI-Host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String jsonData = response.body();

            // Parse the JSON data
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            // Create a table based on JSON keys
            createTableBasedOnJsonKeys(jsonNode);

            // Insert key-value pairs into the dynamic table (modify this logic as needed)
            insertIntoDatabase(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create a table based on JSON keys
    private void createTableBasedOnJsonKeys(JsonNode jsonNode) {
        try (Connection connection = dataSource.getConnection()) {
            StringBuilder createTableSQL = new StringBuilder(
                    "CREATE TABLE IF NOT EXISTS yahoo_data (id INT AUTO_INCREMENT PRIMARY KEY");

            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String columnName = fieldNames.next();
                createTableSQL.append(", ").append(columnName).append(" TEXT");
            }

            createTableSQL.append(")");

            Statement statement = connection.createStatement();
            statement.execute(createTableSQL.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a method to insert key-value pairs into the dynamic table,
    // preventing duplicates based on symbol
    private void insertIntoDatabase(JsonNode jsonNode) {
        try (Connection connection = dataSource.getConnection()) {
            // Check if the symbol already exists in the table
            String symbol = jsonNode.get("symbol").asText(); // Assuming 'symbol' is the key for the symbol field
            PreparedStatement checkStatement = connection.prepareStatement("SELECT COUNT(*) FROM yahoo_data WHERE symbol = symbol");
            ResultSet resultSet = checkStatement.executeQuery();

            // If a record with the same symbol exists, do nothing (skip insertion)
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Optionally, you can log a message indicating that the record was skipped
                System.out.println("Record with symbol " + symbol + " already exists. Skipping insertion.");
            } else {
                // Record doesn't exist, insert it
                StringBuilder insertSQL = new StringBuilder("INSERT INTO yahoo_data (");
                StringBuilder valuesSQL = new StringBuilder(") VALUES (");

                Iterator<String> fieldNames = jsonNode.fieldNames();
                while (fieldNames.hasNext()) {
                    String columnName = fieldNames.next();
                    insertSQL.append(columnName);
                    valuesSQL.append("?");
                    if (fieldNames.hasNext()) {
                        insertSQL.append(", ");
                        valuesSQL.append(", ");
                    }
                }

                insertSQL.append(valuesSQL).append(")");
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL.toString());

                fieldNames = jsonNode.fieldNames();
                int index = 1;
                while (fieldNames.hasNext()) {
                    String key = fieldNames.next();
                    JsonNode value = jsonNode.get(key);
                    preparedStatement.setString(index, value.toString()); // Convert value to string
                    index++;
                }

                preparedStatement.executeUpdate();

                // Optionally, you can log a message indicating that a new record was inserted
                System.out.println("New record with symbol " + symbol + " inserted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
