package arrays.bai_tap;

import java.util.Scanner;

public class FindMinInArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length,i=0;
        do {
            System.out.print("Input length of arrays : ");
            length = scanner.nextInt();
            if (length > 0){
                break;
            }else System.out.print("Sorry ! Invalid length !");
        }while (true);
        int[] arrays = new int[length];
        while (i < length) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arrays[i] = scanner.nextInt();
            i++;
        }
        int min = arrays[0];
        for (int j=1;j<length;j++){
            if (arrays[j]<min){
                min = arrays[j];
            }
        }
        System.out.print("Min of arrays is : " + min);
    }
}
