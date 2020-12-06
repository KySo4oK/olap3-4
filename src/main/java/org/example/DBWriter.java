package org.example;

import org.example.entity.Description;
import org.example.entity.Metadata;
import org.example.entity.Movie;
import org.example.entity.Rating;
import org.example.entity.enums.DescriptionType;
import org.example.entity.enums.MetadataType;
import org.example.entity.enums.RatingType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWriter {

    public static final String INSERT_COMBINED_MOVIES = "insert into combined_movies (movie, rating, year_rus, country, rating_rus, overview, director, screenwriter, actors,\n" +
            "                             url_logo, title, rank, year_eng, linkmeta, rating_eng, duration, genre, metadate,\n" +
            "                             summarytext)\n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String CONNECTION_FAILURE = "Connection failure.";
    private static final String DESCRIPTION_QUERY = "insert into description_types(description_id, description_type)\n" +
            "values (?, ?);";
    private static final String METADATA_QUERY = "insert into metadata_types(metadata_id, metadata_type)\n" +
            "values (?, ?);";
    private static final String RATING_QUERY = "insert into rating_types(rating_id, rating_type)\n" +
            "values (?, ?);";
    private static final String FIND_ALL_DIRTY_DATA_QUERY = "select rating as \"rating\",\n" +
            "       movie as \"movie\",\n" +
            "       year_rus as \"year_rus\",\n" +
            "       country as \"country\",\n" +
            "       rating_rus as \"rating_rus\",\n" +
            "       overview as \"overview\",\n" +
            "       director as \"director\",\n" +
            "       screenwriter as \"screenwriter\",\n" +
            "       actors as \"actors\",\n" +
            "       url_logo as \"url_logo\",\n" +
            "       rank as \"rank\",\n" +
            "       title as \"title\",\n" +
            "       year_eng as \"year_eng\",\n" +
            "       linkmeta as \"linkmeta\",\n" +
            "       rating_eng as \"rating_eng\",\n" +
            "       duration as \"duration\",\n" +
            "       genre as \"genre\",\n" +
            "       metadate as \"metadate\",\n" +
            "       summarytext as \"summarytext\"\n" +
            "from combined_movies;";
    private static final String INSERT_RATING_RELATION = "insert into movies2ratings(movie_title, rating_id, rating)\n" +
            "VALUES (?, ?, ?)";
    private static final String INSERT_DESCRIPTION_RELATION = "insert into movies2descriptions (movie_title, description_id, description)\n" +
            "values (?, ?, ?)";
    private final MovieMapper movieMapper = new MovieMapper();
    private static final String INSERT_MOVIES = "insert into movies(title, year, country, director, actors, genre, screenwriter)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_METADATA_RELATION = "insert into movies2metadata(movie_title, metadata_id, metadata)\n" +
            "VALUES (?, ?, ?)";

    public void writeDirtyData(List<List<String>> result) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_COMBINED_MOVIES)) {
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
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(RATING_QUERY)) {
                connection.setAutoCommit(false);
                for (RatingType ratingType : RatingType.values()) {
                    statement.setString(1, String.valueOf(ratingType.ordinal()));
                    statement.setString(2, ratingType.toString());
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
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(DESCRIPTION_QUERY)) {
                connection.setAutoCommit(false);
                for (DescriptionType descriptionType : DescriptionType.values()) {
                    statement.setString(1, String.valueOf(descriptionType.ordinal()));
                    statement.setString(2, descriptionType.toString());
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
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(METADATA_QUERY)) {
                connection.setAutoCommit(false);
                for (MetadataType metadataType : MetadataType.values()) {
                    statement.setString(1, String.valueOf(metadataType.ordinal()));
                    statement.setString(2, metadataType.toString());
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

    private Connection getConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "root");
    }

    public List<Movie> readDirtyDataFromDB() {
        List<Movie> movies = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_DIRTY_DATA_QUERY);
            while (resultSet.next()) {
                movies.add(movieMapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(CONNECTION_FAILURE);
            e.printStackTrace();
        }
        return movies;
    }

    public void writeMovies(List<Movie> movies) throws SQLException {
        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_MOVIES);
             PreparedStatement statementForMetadata = connection.prepareStatement(INSERT_METADATA_RELATION);
             PreparedStatement statementForRating = connection.prepareStatement(INSERT_RATING_RELATION);
             PreparedStatement statementForDescription = connection.prepareStatement(INSERT_DESCRIPTION_RELATION);
        ) {
            connection.setAutoCommit(false);
            for (Movie movie : movies) {
                statement.setString(1, movie.getTitle());
                statement.setString(2, movie.getYear());
                statement.setString(3, movie.getCountry());
                statement.setString(4, movie.getDirector());
                statement.setString(5, movie.getActors());
                statement.setString(6, movie.getGenre());
                statement.setString(7, movie.getScreenwriter());
                statement.addBatch();
                for (Description description : movie.getDescription()) {
                    statementForDescription.setString(1, movie.getTitle());
                    statementForDescription.setString(2,
                            String.valueOf(description.getDescriptionType().ordinal()));
                    statementForDescription.setString(3, description.getDescriptionName());
                    statementForDescription.addBatch();
                }
                for (Rating rating : movie.getRating()) {
                    statementForRating.setString(1, movie.getTitle());
                    statementForRating.setString(2,
                            String.valueOf(rating.getRatingType().ordinal()));
                    statementForRating.setString(3, rating.getRatingName());
                    statementForRating.addBatch();
                }
                for (Metadata metadata : movie.getMetadata()) {
                    statementForMetadata.setString(1, movie.getTitle());
                    statementForMetadata.setString(2,
                            String.valueOf(metadata.getMetadataType().ordinal()));
                    statementForMetadata.setString(3, metadata.getMetadataName());
                    statementForMetadata.addBatch();
                }
            }
            statement.executeBatch();
            statementForDescription.executeBatch();
            statementForMetadata.executeBatch();
            statementForRating.executeBatch();
            connection.commit();
        }
    }
}
