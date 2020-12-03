package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    static List<List<String>> data = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile("imdb.csv");
    }

    public static void loadFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            Scanner scan = new Scanner(reader);
            ArrayList<String> lines = new ArrayList<>();
            scan.nextLine();
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
            data.addAll(lines.stream()
                    .map(line -> Arrays.asList(line.split(",")))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public static void printArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr[0].length; i++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}