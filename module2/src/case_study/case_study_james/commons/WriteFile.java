package case_study.case_study_james.commons;

import case_study.case_study_james.models.Entities;

import java.io.*;
import java.util.List;

public class WriteFile {
    private static final String FILE_DICTIONARY = "src/case_study/case_study_james/data/Dictionary.txt";

    public static void write(List<Entities> list) {
        FileOutputStream file = null;
        ObjectOutputStream outputStream = null;
        try {
            file = new FileOutputStream(FILE_DICTIONARY);
            outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(list);
        } catch (FileNotFoundException e) {
            System.out.println("File don't exits");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
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
    }
}
