package org.example;

import org.example.entity.Movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws SQLException {
//        CSVParser parser = new CSVParser();
//
//        List<List<String>> imdb = parser.loadFromFile("src/csv-tables/imdb.csv", ";");
//        List<List<String>> kinopoisk = parser.loadFromFile("src/csv-tables/kinopoisk.csv", ",");
//
////        List<String> imdbHeader = imdb.remove(0);
////        List<String> kinopoiskHeader = kinopoisk.remove(0);
//
//        DataMerger merger = new DataMerger();
//        Map<String, List<String>> imdbMap = merger.convertDataToMap(imdb, 1);
//        Map<String, List<String>> kinopoiskMap = merger.convertDataToMap(kinopoisk, 1);
//
//        List<List<String>> result = merger.mergeTwoMaps(kinopoiskMap, imdbMap);
        DBWriter dbWriter = new DBWriter();
//        dbWriter.writeDirtyData(result);
//        dbWriter.writeEnums();
        List<Movie> movies = dbWriter.readDirtyDataFromDB();
        System.out.println(movies);
        dbWriter.writeMovies(movies);
    }
}