package thuat_toan_sap_xep.thuc_hanh;

import java.util.Scanner;

public class PracticeBubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size : ");
        int size = scanner.nextInt();

        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values : ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.print("Your input list: ");
        for (int value : list) {
            System.out.print(value + " ");
        }

        System.out.println("\nBegin sort processing :");
        practiceBubbleSortByStep(list);
    }

    public static void practiceBubbleSortByStep(int[] list) {
        for (int k = 1; k < list.length; k++) {
            boolean needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
            /* Array may be sorted and next pass not needed */
            if (!needNextPass) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            /* Show the list after sort */
            System.out.print("List after the  " + k + "' sort: ");
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
