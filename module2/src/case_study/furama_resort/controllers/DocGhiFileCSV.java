package case_study.furama_resort.controllers;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DocGhiFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void ghiFile(String tenFile, ArrayList mang) {
        String path = "";
        if (tenFile.equals("Villa")) path = "E:\\C0620G1\\module2\\src\\case_study\\furama_resort\\data\\Villa.csv";
        if (tenFile.equals("House")) path = "E:\\C0620G1\\module2\\src\\case_study\\furama_resort\\data\\House.csv";
        if (tenFile.equals("Room")) path = "E:\\C0620G1\\module2\\src\\case_study\\furama_resort\\data\\Room.csv";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
