package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.Scanner;

public class DemoQuanLySanPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm\n2. Sửa thông tin sản phẩm\n3. Xóa sản phẩm" +
                    "\n4. Hiển thị danh sách sản phẩm\n5. Tìm kiếm sản phẩm\n6. Sắp xếp sản phẩm\n7. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    QuanLySanPham.them();
                    break;
                case 4:
                    System.out.println("Danh sách sản phẩm : \n" + QuanLySanPham.hienThi());
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 7:
                    return;
            }
        } while (true);
    }
}
