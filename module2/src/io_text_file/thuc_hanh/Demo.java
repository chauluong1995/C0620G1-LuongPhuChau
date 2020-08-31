package io_text_file.thuc_hanh;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            menu();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void menu() throws IOException {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm\n2. Sửa thông tin sản phẩm\n3. Xóa sản phẩm" +
                    "\n4. Hiển thị danh sách sản phẩm\n5. Tìm kiếm sản phẩm\n6. Sắp xếp sản phẩm theo giá\n7. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        themSanPham();
                        break;
                    case 2:
                        break;
                    case 3:
                        xoaSanPham();
                        break;
                    case 4:
                        //break;
                    case 5:
                        break;
                    case 6:
                        //break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else System.out.println("Lựa chọn không hợp lệ !");
        } while (true);
    }

    public static void themSanPham() throws IOException {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm nhập khẩu\n2. Thêm sản phẩm xuất khẩu\n3. Quay về menu chính\n4. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        Them.themSanPhamNhapKhau();
                        break;
                    case 2:
                        Them.themSanPhamXuatKhau();
                        break;
                    case 3:
                        menu();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else System.out.println("Lựa chọn không hợp lệ !");
        } while (true);
    }

    public static void xoaSanPham() throws IOException {
        List<SanPham> list = LuuFileCSV.docFile();

    }
}
