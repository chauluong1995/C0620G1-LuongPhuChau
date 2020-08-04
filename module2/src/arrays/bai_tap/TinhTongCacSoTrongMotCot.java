package arrays.bai_tap;

import java.util.Scanner;

public class TinhTongCacSoTrongMotCot {
    public static void main(String[] args) {
        int soCot,soDong,cotTinhTong,tong;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(" Nhập số cột của ma trận : ");
            soCot = scanner.nextInt();
            if (soCot>0){
                break;
            }else System.out.println(" Số cột của bạn không hợp lí !");
        } while (true);
        do {
            System.out.print(" Nhập số dòng của ma trận : ");
            soDong = scanner.nextInt();
            if (soDong>0){
                break;
            }else System.out.println(" Số dòng của bạn không hợp lí !");
        } while (true);

        int[][] maTran = new int[soCot][soDong];
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soDong;j++){
                System.out.print(" Nhập phần tử của ma trận : ");
                maTran[i][j] = scanner.nextInt();
            }
        }

        System.out.println(" Các phần tử của ma trận là : ");
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soDong;j++){
                System.out.print(" " + maTran[i][j] + " ");
            }
            System.out.println();
        }

        do {
            System.out.print(" Nhập số cột của ma trận cần tính tổng : ");
            cotTinhTong = scanner.nextInt() - 1;
            if (cotTinhTong>=0 && cotTinhTong<soCot){
                break;
            }else System.out.println(" Số cột của bạn không hợp lí !");
        } while (true);
        tong = 0;
        for (int j=0;j<soDong;j++){
            tong += maTran[cotTinhTong][j];
        }
        System.out.print(" Các phần tử của cột cần tính tổng là : ");
        for (int j=0;j<soDong;j++){
            System.out.print(maTran[cotTinhTong][j] + " ");
        }
        //System.out.println();
        System.out.print(" Tổng các phần tử đó là : " + tong);
    }
}
