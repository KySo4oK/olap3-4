package org.example;

import java.sql.*;
import java.util.List;

public class DBWriter {

    public static final String query = "insert into combined_movies (rating, movie, year_eng, country, rating_eng, overview, director, screenwriter, actors,\n" +
            "                             url_logo, rank, title, year_rus, linkmeta, rating_rus, duration, genre, metadate,\n" +
            "                             summarytext)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public void write(List<List<String>> result) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                connection.setAutoCommit(false);
                for (List<String> line : result) {
                    for (int i = 0, oneLineSize = line.size(); i < oneLineSize; i++) {
                        String singleData = line.get(i);
                        statement.setString(i+1, singleData);
                        statement.addBatch();
                    }
                    statement.executeBatch();
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
