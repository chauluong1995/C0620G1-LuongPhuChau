package case_study.case_study_james.commons;

import case_study.case_study_james.models.Entities;

import java.io.*;
import java.util.List;

public class ReadWriteDictionary {
    private static final String COMMAND = ",";

    public static boolean testFile(String word) {
        String path = "src/case_study/case_study_james/data/" + word + ".txt";
        File file = new File(path);
        return file.isFile();
    }

    public static void writeFile(List<Entities> params, String word) {
        File file = new File("src/case_study/case_study_james/data/" + word + ".txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (testFile(word)) fileWriter = new FileWriter(file, true);
            else fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            Entities entities = params.get(0);
            stringBuilder.append(entities.getKeyword()).append(COMMAND).append(entities.getType()).append(COMMAND).append(entities.getMean());
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.append("\n");
            bufferedWriter.flush();
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bufferedWriter != null) bufferedWriter.close();
                    fileWriter.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
