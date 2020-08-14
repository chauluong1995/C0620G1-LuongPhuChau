package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {
    public static Scanner scanner = new Scanner(System.in);
    public static List<SanPham> listSanPham = new ArrayList<>();

    public static void them() {
        System.out.print("Nhập tên sản phẩm : ");
        scanner.nextLine();
        String tenSanPham = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm : ");
        int giaSanPham = scanner.nextInt();
        listSanPham.add(new SanPham(tenSanPham, giaSanPham));
    }

    public static List<SanPham> hienThi(){
        return listSanPham;
    }
}
