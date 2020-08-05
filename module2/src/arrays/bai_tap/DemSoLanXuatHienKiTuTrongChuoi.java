package arrays.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienKiTuTrongChuoi {
    public static void main(String[] args) {
        String chuoi = "Cai nay em khong biet lam";
        int bienDem = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập 1 kí tự bạn muốn xem số lần xuất hiện của nó trong chuỗi 'Cai nay em khong biet lam' : ");
        char kiTu = scanner.next().charAt(0);
        for (int i=0;i<chuoi.length();i++){
            if (kiTu == chuoi.charAt(i)){
                bienDem++;
            }
        }
        if (bienDem>0){
            System.out.print("Kí tự bạn nhập là "+kiTu+" , nó xuất hiện "+bienDem+" lần trong chuỗi 'Cai nay em khong biet lam'");
        }else System.out.print("Kí tự bạn nhập là "+kiTu+" , nó không xuất hiện trong chuỗi 'Cai nay em khong biet lam'");
    }
}
