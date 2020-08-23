package io_binary_file_serialization.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm\n2. Hiển thị danh sách sản phẩm\n3. Tìm kiếm sản phẩm\n4. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String luaChon = scanner.nextLine();
            switch (luaChon) {
                case "1":
                    FileNhiPhanQuanLySanPham.them();
                    scanner.nextLine();
                    break;
                case "2":
                    FileNhiPhanQuanLySanPham.hienThi();
                    scanner.nextLine();
                    break;
                case "3":
                    FileNhiPhanQuanLySanPham.timKiem();
                    scanner.nextLine();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không tồn tại !");
                    scanner.nextLine();
            }
        } while (true);
    }
}
