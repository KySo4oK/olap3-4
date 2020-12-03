package org.example;

import java.util.List;

public class App {

    public static void main(String[] args) {
        CSVParser parser = new CSVParser();

        List<List<String>> imdb = parser.loadFromFile("imdb.csv");
        List<List<String>> kinopoisk = parser.loadFromFile("kinopoisk.csv");
    }
}