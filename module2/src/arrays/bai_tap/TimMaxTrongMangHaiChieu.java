package arrays.bai_tap;

import java.util.Scanner;

public class TimMaxTrongMangHaiChieu {
    public static void main(String[] args) {
        int soCot,soDong,viTriTrongCot,viTriTrongDong;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập số cột của ma trận : ");
            soCot = scanner.nextInt();
            if (soCot>0){
                break;
            }else System.out.print("Số cột của bạn không hợp lí ! ");
        } while (true);
        do {
            System.out.print("Nhập số dòng của ma trận : ");
            soDong = scanner.nextInt();
            if (soDong>0){
                break;
            }else System.out.print("Số dòng của bạn không hợp lí ! ");
        } while (true);

        double[][] maTran = new double[soCot][soDong];
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soDong;j++){
                System.out.print("Nhập phần tử của ma trận : ");
                maTran[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Các phần tử của ma trận là : ");
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soDong;j++){
                System.out.print(maTran[i][j] + " ");
            }
            System.out.println();
        }

        double max = maTran[0][0];
        viTriTrongCot = 0;
        viTriTrongDong = 0;
        for (int i=0;i<soCot;i++){
            for (int j=0;j<soDong;j++){ // Chính xác là j < số dòng của cột đang duyệt : j<maTran[i].length (Được sử dụng khi ma trận không vuông mà dạng lộn xộn) !
                if (maTran[i][j]>max){
                    max = maTran[i][j];
                    viTriTrongCot = i;
                    viTriTrongDong = j;
                }
            }
        }
        System.out.print("Phần tử lớn nhất trong ma trận là : maTran["+viTriTrongCot+"]["+viTriTrongDong+"] = " + max);
    }
}
