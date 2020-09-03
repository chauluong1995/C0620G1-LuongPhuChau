package case_study.case_study_james.commons;

import case_study.case_study_james.models.Entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteDictionary {
    private static final String COMMAND = ",";

    public static void writeFile(List<String> params, String word) {
        File file = new File("src/case_study/case_study_james/data/" + word + ".txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (file.isFile()) fileWriter = new FileWriter(file, true);
            else fileWriter = new FileWriter(file);

            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();

            int i = 0;
            for (String element : params) {
                stringBuilder.append(element);
                if (i == params.size() - 1) break;
                stringBuilder.append("\n");
                i++;
            }

            bufferedWriter.write(stringBuilder.toString());
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

    public static List<Entities> readFile(String word) {
        List<Entities> list = new ArrayList<>();
        File file = new File("src/case_study/case_study_james/data/" + word + ".txt");
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                Entities entities;
                String[] temp;
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    temp = line.split(COMMAND);
                    entities = new Entities(temp[0], temp[1]);
                    list.add(entities);
                }
            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                try {
                    if (fileReader != null) {
                        if (bufferedReader != null) bufferedReader.close();
                        fileReader.close();
                    }
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
        return list;
    }
}
