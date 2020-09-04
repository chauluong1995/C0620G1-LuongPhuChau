package io_binary_file_serialization.thuc_hanh.demo;

import java.util.Scanner;

public class Validate {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static String kiemTraEmail(){
        String email;
        do {
            System.out.print("Nhập email : ");
            email = scanner.nextLine();
            if (email.matches("^\\w+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$")) break;
            else System.out.println("Sai định dạng email ! Email có dạng abc@abc.abc");
        } while (true);
        return email;
    }

    public static String kiemTraSDT(){
        String sdt;
        do {
            System.out.print("Nhập sdt : ");
            sdt = scanner.nextLine();
            if (sdt.matches("^\\d{10}$")) break;
            else System.out.println("SDT sai định dạng ! SDT có dạng XXXXXXXXX với X là số từ 0 tới 9 !");
        } while (true);
        return sdt;
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
