package io_text_file.thuc_hanh;

import java.util.Scanner;

public class Regex {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap) {
        return nhap.matches("\\d+(\\.\\d+)?");
    }

    public static String kiemTraNhapSo(String thongTin) {
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (kiemTraNhapSoThuc(nhapThongTin) && Float.parseFloat(nhapThongTin) > 0) break;
            else System.out.println("Thông tin không hợp lệ !");
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraNhapChu(String thongTin){
        String nhapThongTin ;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals("")) System.out.println("Thông tin không được bỏ trống !");
            else break;
        } while (true);
        return nhapThongTin;
    }
}
