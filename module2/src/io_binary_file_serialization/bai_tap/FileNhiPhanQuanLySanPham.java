package io_binary_file_serialization.bai_tap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileNhiPhanQuanLySanPham {
    public static Scanner scanner = new Scanner(System.in);

    public static void them() throws FileNotFoundException {
        FileOutputStream fileOutput = new FileOutputStream("E:\\C0620G1\\module2\\src\\io_binary_file_serialization\\bai_tap");


        System.out.print("Nhập số lượng sản phẩm muốn thêm : ");
        int soLuong = scanner.nextInt();
        scanner.skip("\\R");
        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhập mã sản phẩm : ");
            int maSanPham = scanner.nextInt();
            scanner.skip("\\R");

            System.out.print("\nNhập tên sản phẩm : ");
            String ten = scanner.nextLine();

            System.out.print("\nNhập hãng sản xuất : ");
            String hangSanXuat = scanner.nextLine();

            System.out.print("\nNhập giá sản phẩm : ");
            int gia = scanner.nextInt();
            scanner.skip("\\R");

            System.out.print("Nhập mô tả khác cho sản phẩm : ");
            String moTa = scanner.nextLine();



            System.out.print("Thêm sản phẩm thành công !");
            if (i < soLuong - 1) {
                System.out.println(" Nhập thông tin sản phẩm tiếp theo :");
            }
        }

    }
}
