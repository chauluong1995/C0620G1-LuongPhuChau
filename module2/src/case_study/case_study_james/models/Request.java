package case_study.case_study_james.models;

import case_study.case_study_james.commons.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Request {
    private String action;
    private List<Entities> params = new ArrayList<>();
    private String keyword;

    public Request() {
    }

    public Request(String action, List<Entities> params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public List<Entities> getParams() {
        return params;
    }

    public void setParams(LinkedList<Entities> params) {
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public void checkAction() {
        //this.params = ReadFile.read();
        if (this.action.equals("lookup")) Service.lookup(params, this.keyword);
        else if (this.action.equals("define")) Service.define(params, this.keyword);
        else Service.drop(params, this.keyword);
    }

//    private void lookup(String word) {
//        boolean search = true;
//        if (params.size() != 0) {
//            for (Entities entities : params) {
//                if (entities.getKeyword().equals(word)) {
//                    search = false;
//                    System.out.println(this.keyword + entities);
//                }
//            }
//            if (search) System.out.println(this.keyword + " don't exits in dictionary !");
//        } else System.out.println("Dictionary is Empty !");
//    }
//
//    private void define(String word) {
//        Entities entities = new Entities();
//        String type;
//        do {
//            System.out.print("Type of word : ");
//            type = scanner.nextLine();
//            if (type.matches("^((verb)|(adjective)|(noun)|(pronoun))$")) break;
//            else System.out.println("Input 1 in 5 : verb , adjective , noun , pronoun !");
//        } while (true);
//        entities.setType(type);
//        if (params.size() != 0) {
//            for (Entities entities_1 : params) {
//                boolean isExitsKeyWord = entities_1.getKeyword().equals(word);
//                boolean isExitsTypeWord = entities_1.getType().equals(entities.getType());
//                if (isExitsKeyWord && isExitsTypeWord) {
//                    System.out.println(word + " is exits");
//                    return;
//                }
//            }
//        } else System.out.println("Dictionary is Empty !");
//        entities.setKeyword(word);
//        System.out.print("Insert mean of word : ");
//        String mean = scanner.nextLine();
//        entities.setMean(mean);
//        params.add(entities);
//        WriteFile.write(params);
//    }
//
//    private void drop(String word) {
//        Entities entities;
//        if (params.size() == 0) {
//            System.out.println("Nothing");
//        }
//        if (params.size() != 0) {
//            for (int i = 0; i < params.size(); i++) {
//                if (params.get(i).getKeyword().equals(this.keyword)) {
//                    entities = params.get(i);
//                    params.remove(entities);
//                }
//            }
//        }
//        WriteFile.write(params);
//    }

}
