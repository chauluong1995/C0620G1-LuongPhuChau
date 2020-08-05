package arrays.bai_tap;

import java.util.Scanner;

public class TinhTongDuongCheoMaTran {
    public static void main(String[] args) {
        int soCot;
        //int soDong;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập số cột của ma trận : ");
            soCot = scanner.nextInt();
            if (soCot>0){
                break;
            }else System.out.println(" Số cột của bạn không hợp lí !");
        } while (true);
//        do {
//            System.out.print("Nhập số dòng của ma trận : ");
//            soDong = scanner.nextInt();
//            if (soDong>0){
//                break;
//            }else System.out.println("Số dòng của bạn không hợp lí !");
//        } while (true);

        int[][] maTran = new int[soCot][soCot];
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soCot;j++){
                System.out.print("Nhập phần tử ở vị trí ["+i+"]["+j+"] của ma trận :  ");
                maTran[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Các phần tử của ma trận là : ");
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soCot;j++){
                System.out.print(" " + maTran[i][j] + " ");
            }
            System.out.println();
        }

        int tong = 0;
        for (int i=0;i<soCot;i++){
            tong += maTran[i][i];
        }
        System.out.println("Tổng các phần tử trên đường chéo từ trái qua phải của ma trận là : " + tong);

        int tong2 = 0;
        for (int i=0,j=soCot-1;i<soCot;i++,j--){
            tong2 += maTran[i][j];
        }
        System.out.print("Tổng các phần tử trên đường chéo từ phải qua trái của ma trận là : " + tong2);
    }
}
