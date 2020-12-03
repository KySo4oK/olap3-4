package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static String[][] pressures;
    public static void main(String[] args) {
        pressures = new String[21][12];
        loadFromFile("coursework.csv");
        setToFile("pressures.csv");
    }

    public static void loadFromFile(String fileName){
        try(FileReader reader = new FileReader(fileName)) {
            Scanner scan = new Scanner(reader);
            ArrayList<String> lines = new ArrayList<>();
            scan.nextLine();
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
            for(int i = 0; i < lines.size(); i++ ) {
                String[] line = lines.get(i).split(";");
                pressures[Integer.parseInt(line[0]) - 1999][Integer.parseInt(line[1]) % 12] = line[3];
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public static void setToFile(String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("year;Січень;Лютий;Березень;Квітень;Травень;Червень;Липень;Серпень;Вересень;Жовтень;Листопад;Грудень;" + "\r\n");
            for (int i = 0; i < pressures.length; i++) {
                int year = i + 1999;
                fileWriter.write(year + ";");
                for (int j = 0; j < pressures[0].length; j++) {
                    fileWriter.write(pressures[i][j] + ";");
                }
                fileWriter.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArr(String [][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; i < arr[0].length; i++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}