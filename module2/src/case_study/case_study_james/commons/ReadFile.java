package case_study.case_study_james.commons;

import case_study.case_study_james.models.Entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static final String FILE_DICTIONARY = "src/case_study/case_study_james/data/Dictionary.txt";

    public static List<Entities> read() {
        List<Entities> list = new ArrayList<>();
        FileInputStream file = null;
        ObjectInputStream inputStream = null;
        try {
            file = new FileInputStream(FILE_DICTIONARY);
            inputStream = new ObjectInputStream(file);
            list = (List<Entities>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File don't exits");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            System.out.println("File null");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
