package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.Scanner;

public class DemoQuanLySanPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm\n2. Sửa thông tin sản phẩm\n3. Xóa sản phẩm" +
                    "\n4. Hiển thị danh sách sản phẩm\n5. Tìm kiếm sản phẩm\n6. Sắp xếp sản phẩm\n7. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            int choose = Integer.parseInt(scanner.nextLine());
            //scanner.skip("\\R");
            switch (choose) {
                case 1:
                    QuanLySanPham.them();
                    break;
                case 2:
                    QuanLySanPham.sua();
                    scanner.nextLine();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Danh sách sản phẩm : \n" + QuanLySanPham.hienThi());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm bạn muốn tìm : ");
                    String ten = scanner.nextLine();
                    System.out.println(QuanLySanPham.timKiem(ten));
                    scanner.nextLine();
                    break;
                case 6:
                    break;
                case 7:
                    return;
            }
        } while (true);
    }
}
