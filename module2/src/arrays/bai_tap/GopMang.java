package arrays.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int[] mang1 = new int[3];
        int[] mang2 = new int[5];
        int[] mangGop = new int[8];
        int i=0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập phần tử mảng 1 :");
        while (i < mang1.length) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
            mang1[i] = scanner.nextInt();
            i++;
        }

        i=0;
        System.out.println("Nhập phần tử mảng 2 :");
        while (i < mang2.length) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
            mang2[i] = scanner.nextInt();
            i++;
        }

        System.arraycopy(mang1,0,mangGop,0,mang1.length);
        System.arraycopy(mang2,0,mangGop,mang1.length,mang2.length);

        System.out.print("Mảng 1 có các phần tử là : ");
        for (int element : mang1){
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.print("Mảng 2 có các phần tử là : ");
        for (int element : mang2){
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.print("Mảng sau khi gộp có các phần tử là : ");
        for (int element : mangGop){
            System.out.print(element + " ");
        }
    }
}
