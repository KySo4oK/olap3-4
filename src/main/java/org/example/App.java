package org.example;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        CSVParser parser = new CSVParser();

        List<List<String>> imdb = parser.loadFromFile("imdb.csv");
        List<List<String>> kinopoisk = parser.loadFromFile("kinopoisk.csv");

        List<String> imdbHeader = imdb.remove(0);
        List<String> kinopoiskHeader = kinopoisk.remove(0);

        DataMerger merger = new DataMerger();
        Map<String, List<String>> imdbMap = merger.convertDataToMap(imdb, 1);
        Map<String, List<String>> kinopoiskMap = merger.convertDataToMap(imdb, 1);
    }
}