package bai_thi;

import java.util.Scanner;

public class Regex {
    public static Scanner nhap = new Scanner(System.in);

    public static boolean kiemTraNhapSoNguyen(String thongTin) {
        return thongTin.matches("\\d+");
    }

    public static String kiemTraEmail() {
        String email;
        do {
            System.out.print("Nhập email : ");
            email = nhap.nextLine();
            if (email.matches("^\\w+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$")) break;
            else System.out.println("Sai định dạng email ! Email có dạng abc@abc.abc");
        } while (true);
        return email;
    }

    public static String kiemTraSoDienThoai() {
        String soDienThoai;
        do {
            System.out.print("Nhập số điện thoại : ");
            soDienThoai = nhap.nextLine();
            if (soDienThoai.matches("^\\d{10}$")) break;
            else
                System.out.println("Số điện thoại sai định dạng ! Số điện thoại có dạng XXXXXXXXX với X là số từ 0 tới 9 !");
        } while (true);
        return soDienThoai;
    }

    public static String kiemTraNhapThongTin(String thongTin) {
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = nhap.nextLine();
            if (nhapThongTin.equals("")) System.out.println("Thông tin không được bỏ trống !");
            else break;
        } while (true);
        return nhapThongTin;
    }
}
