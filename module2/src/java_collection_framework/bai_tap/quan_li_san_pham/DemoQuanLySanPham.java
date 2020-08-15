package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.Scanner;

public class DemoQuanLySanPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm\n2. Sửa thông tin sản phẩm\n3. Xóa sản phẩm" +
                    "\n4. Hiển thị danh sách sản phẩm\n5. Tìm kiếm sản phẩm\n6. Sắp xếp sản phẩm theo giá\n7. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (QuanLySanPham.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                if (luaChon >= 1 && luaChon <= 7) {
                    switch (luaChon) {
                        case 1:
                            QuanLySanPham.them();
                            scanner.nextLine();
                            break;
                        case 2:
                            QuanLySanPham.sua();
                            scanner.nextLine();
                            break;
                        case 3:
                            QuanLySanPham.xoa();
                            scanner.nextLine();
                            break;
                        case 4:
                            System.out.print(QuanLySanPham.hienThi());
                            scanner.nextLine();
                            break;
                        case 5:
//                            System.out.print("Nhập tên sản phẩm bạn muốn tìm : ");
//                            String tenMuonTim = scanner.nextLine();
//                            System.out.print(QuanLySanPham.timKiem(tenMuonTim));
                            System.out.print(QuanLySanPham.timKiem());
                            scanner.nextLine();
                            break;
                        case 6:
                            QuanLySanPham.sapXep();
                            scanner.nextLine();
                            break;
                        case 7:
                            System.exit(0);
                            //return;
                    }
                } else {
                    System.out.print("Lựa chọn không tồn tại !");
                    scanner.nextLine();
                }
            } else {
                System.out.print("Lựa chọn không hợp lệ !");
                scanner.nextLine();
            }
        } while (true);
    }
}
