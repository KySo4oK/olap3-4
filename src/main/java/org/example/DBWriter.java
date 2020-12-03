package org.example;

import java.sql.*;
import java.util.List;

public class DBWriter {
    public void write(List<List<String>> result) {
        for (List<String> line : result) {
            writeOneLine(line);
        }
    }

    private void writeOneLine(List<String> oneLine) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root")) {
            try (PreparedStatement statement = connection.prepareStatement("")) {
                for (int i = 0, oneLineSize = oneLine.size(); i < oneLineSize; i++) {
                    String singleData = oneLine.get(i);
                    statement.setString(i, singleData);
                }
                statement.execute();
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}
