package case_study.case_study_james.controllers;

import case_study.case_study_james.models.Request;

import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            String action;
            do {
                System.out.println("In put e ( acronym of exit ) to exit the program  !");
                System.out.print("Action: ");
                action = scanner.nextLine();
                if (action.equals("e")) System.exit(0);
                if (action.matches("^((lookup)|(define)|(drop))\\s\\D+$")) break;
                else System.out.println("==========================================================\nInput lookup word for search !" +
                        "\nInput define word for add or edit !\nInput drop word for delete !" +
                        "\nExample : Input lookup pro to search mean of pro !" +
                        "\n==========================================================");
            } while (true);
            String[] string = action.split("\\s");
            Request request = new Request();
            request.setAction(string[0]);
            request.setKeyword(string[1]);
            request.checkAction();
        } while (true);
    }
}


