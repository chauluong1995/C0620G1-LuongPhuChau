package case_study.case_study_james.commons;

import case_study.case_study_james.models.Entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private static Scanner scanner = new Scanner(System.in);

    public static void lookup(String word) {
        List<Entities> list = ReadWriteDictionary.readFile(word);
        if (list.isEmpty()) System.out.println(word + " is not existed in dictionary !");
        else {
            for (Entities entities : list) {
                System.out.println(entities.showInfo());
            }
        }
    }

    public static void define(List<String> params, String word) {
        String type = params.get(0);
        if (type.matches("^(verb)|(adjective)|(noun)|(pronoun)$")) {
            File file = new File("src/case_study/case_study_james/data/" + word + ".txt");
            if (file.isFile()) {
                List<Entities> entitiesList = ReadWriteDictionary.readFile(word);
                if (file.delete()) updateWord(entitiesList, type, word);
                else System.out.println("Update failed !");
            } else newWord(params, word);
        } else System.out.println("Type of word is 1 in 5 : verb , adjective , noun , pronoun !");
    }

    public static void drop(String word) {
        List<Entities> list = ReadWriteDictionary.readFile(word);
        if (list.isEmpty()) System.out.println(word + " is not existed in dictionary !");
        else {
            File file = new File("src/case_study/case_study_james/data/" + word + ".txt");
            if (file.delete()) System.out.println(word + " dropped !");
        }
    }

    public static void newWord(List<String> params, String word) {
        System.out.println(word + " is not existed in dictionary , created new one !");
        List<Entities> listParams = new ArrayList<>();
        String type = params.get(0);
        String mean;
        do {
            System.out.print("Insert mean of word : ");
            mean = scanner.nextLine();
            if (mean.equals("")) System.out.println("Mean can't empty !");
            else break;
        } while (true);
        Entities entities = new Entities(word, type, mean);
        listParams.add(entities);
        ReadWriteDictionary.writeFile(listParams, word);
        System.out.println("Add new word complete !");
    }

    public static void updateWord(List<Entities> entitiesList, String type, String word) {
        boolean test = true;
        for (Entities entities : entitiesList) {
            if (type.equals(entities.getType())) {
                test = false;
                String mean;
                do {
                    System.out.print("Type of word is exist ! Update mean of this type : ");
                    mean = scanner.nextLine();
                    if (mean.equals("")) System.out.println("Mean can't empty !");
                    else break;
                } while (true);
                entities.setMean(mean);
                break;
            }
        }
        if (test) {
            String mean;
            do {
                System.out.print("Type of word is not exist ! Update more ! Update mean of this type : ");
                mean = scanner.nextLine();
                if (mean.equals("")) System.out.println("Mean can't empty !");
                else break;
            } while (true);
            Entities entities = new Entities(word, type, mean);
            entitiesList.add(entities);
        }
        ReadWriteDictionary.writeFile(entitiesList, word);
        System.out.println("Update complete !");
    }

    public static void export(String path) {
        List<Entities> list = new ArrayList<>();
        File[] fileList;
        File file;
        if (path.equals("default")) file = new File("src/case_study/case_study_james/dictionary/newDictionary.txt");
        else file = new File(path);
        if (file.isFile()) {
            File directory = new File("src/case_study/case_study_james/data");
            if (directory.exists()) {
                fileList = directory.listFiles();
                if (fileList != null) {
                    if (fileList.length == 0) System.out.println("Dictionary is Empty !");
                    else {
                        for (File element : fileList) {
                            String pathRoot = element.getPath();
                            pathRoot = pathRoot.substring(37, pathRoot.length() - 4);
                            list.addAll(ReadWriteDictionary.readFile(pathRoot));
                        }
                        if (path.equals("default")) ReadWriteDictionary.writeFile(list, "newDirectory");
                        else ReadWriteDictionary.writeFile(list, path);
                        System.out.println("Exporting 10%..20%..30%..40%..50%..60%..70%..80%..90%..Done !");
//                        System.out.println("=================== Dictionary ===================");
//                        for (Entities entities : list) {
//                            System.out.println(entities.showInfo());
//                        }
                    }
                }
            } else System.out.println("Path root directory wrong !");
        } else System.out.println("Path new file wrong !");
    }
}
