package org.example;

import org.example.entity.enums.DescriptionType;
import org.example.entity.enums.MetadataType;
import org.example.entity.enums.RatingType;

import java.sql.*;
import java.util.List;

public class DBWriter {

    public static final String query = "insert into combined_movies (rating, movie, year_rus, country, rating_rus, overview, director, screenwriter, actors,\n" +
            "                             url_logo, rank, title, year_eng, linkmeta, rating_eng, duration, genre, metadate,\n" +
            "                             summarytext)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String CONNECTION_FAILURE = "Connection failure.";

    public void writeDirtyData(List<List<String>> result) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                connection.setAutoCommit(false);
                for (List<String> line : result) {
                    int oneLineSize = line.size();
                    for (int i = 0; i < oneLineSize; i++) {
                        String singleData = line.get(i);
                        statement.setString(i + 1, singleData);
                    }
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(CONNECTION_FAILURE);
            e.printStackTrace();
        }
    }

    public void writeEnums() {
        writeDescriptionTypes();
        writeRatingTypes();
        writeMetadataTypes();
    }

    private void writeRatingTypes() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(rating_query)) {
                connection.setAutoCommit(false);
                for (RatingType ratingType : RatingType.values()) {
                    statement.setString(1, String.valueOf(ratingType.ordinal()));
                    statement.setString(1, ratingType.toString());
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(CONNECTION_FAILURE);
            e.printStackTrace();
        }
    }

    private void writeDescriptionTypes() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(description_query)) {
                connection.setAutoCommit(false);
                for (DescriptionType descriptionType : DescriptionType.values()) {
                    statement.setString(1, String.valueOf(descriptionType.ordinal()));
                    statement.setString(1, descriptionType.toString());
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(CONNECTION_FAILURE);
            e.printStackTrace();
        }
    }

    private void writeMetadataTypes() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(metadata_query)) {
                connection.setAutoCommit(false);
                for (MetadataType metadataType : MetadataType.values()) {
                    statement.setString(1, String.valueOf(metadataType.ordinal()));
                    statement.setString(1, metadataType.toString());
                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(CONNECTION_FAILURE);
            e.printStackTrace();
        }
    }
}
