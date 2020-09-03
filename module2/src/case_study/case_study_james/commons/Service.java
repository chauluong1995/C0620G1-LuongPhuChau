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
            }
            else newWord(params, word);
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
        List<String> listParams = new ArrayList<>();
        String type = params.get(0);
        System.out.print("Insert mean of word : ");
        String mean = scanner.nextLine();
        Entities entities = new Entities(type, mean);
        listParams.add(entities.toString());
        ReadWriteDictionary.writeFile(listParams, word);
        System.out.println("Add new word complete !");
    }

    public static void updateWord(List<Entities> entitiesList, String type, String word) {
        List<String> stringList = new ArrayList<>();
        boolean test = true;
        for (Entities entities : entitiesList) {
            if (type.equals(entities.getType())) {
                test = false;
                System.out.print("Type of word is exist ! Update mean of this type : ");
                entities.setMean(scanner.nextLine());
            }
            stringList.add(entities.toString());
        }
        if (test) {
            System.out.print("Type of word is not exist ! Update more ! Update mean of this type : ");
            String mean = scanner.nextLine();
            Entities entities = new Entities(type,mean);
            stringList.add(entities.toString());
        }
        ReadWriteDictionary.writeFile(stringList, word);
        System.out.println("Update complete !");
    }
}
