package case_study.case_study_james.commons;

import case_study.case_study_james.models.Entities;

import java.util.List;
import java.util.Scanner;

public class Service {
    private static Scanner scanner = new Scanner(System.in);

    public static void lookup(List<Entities> params, String word) {
        boolean search = true;
        if (params.size() != 0) {
            for (Entities entities : params) {
                if (entities.getKeyword().equals(word)) {
                    search = false;
                    System.out.println(word + entities);
                }
            }
            if (search) System.out.println(word + " don't exits in dictionary !");
        } else System.out.println("Dictionary is Empty !");
    }

    public static void define(List<Entities> params, String word) {
        Entities entities = new Entities();
        entities.setKeyword(word);
        String type;
        do {
            System.out.print("Type of word : ");
            type = scanner.nextLine();
            if (type.matches("^((verb)|(adjective)|(noun)|(pronoun))$")) break;
            else System.out.println("Input 1 in 5 : verb , adjective , noun , pronoun !");
        } while (true);
        entities.setType(type);
        System.out.print("Insert mean of word : ");
        String mean = scanner.nextLine();
        entities.setMean(mean);
        params.add(entities);
        //WriteFile.write(params);
        ReadWriteDictionary.writeFile(params, word);
    }

    public static void drop(List<Entities> params, String word) {
        Entities entities;
        if (params.size() == 0) {
            System.out.println("Nothing");
        }
        if (params.size() != 0) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i).getKeyword().equals(word)) {
                    entities = params.get(i);
                    params.remove(entities);
                }
            }
        }
        WriteFile.write(params);
    }
}
