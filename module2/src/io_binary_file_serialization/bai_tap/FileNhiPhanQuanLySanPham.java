package io_binary_file_serialization.bai_tap;

import java.io.*;
import java.util.*;

public class FileNhiPhanQuanLySanPham {
    public static Scanner scanner = new Scanner(System.in);
    public static List<NhiPhanSanPham> danhSach = new ArrayList<>();
    public static final String PATH = "E:\\C0620G1\\module2\\src\\io_binary_file_serialization\\bai_tap\\demo.bin";

    public static void them() throws Exception {
        docFileNhiPhan();

        System.out.print("Nhập mã sản phẩm : ");
        String maSanPham = scanner.nextLine();

        System.out.print("Nhập tên sản phẩm : ");
        String ten = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất : ");
        String hangSanXuat = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm : ");
        String gia = scanner.nextLine();

        System.out.print("Nhập mô tả khác cho sản phẩm : ");
        String moTa = scanner.nextLine();

        System.out.println("Thêm sản phẩm thành công !");

        danhSach.add(new NhiPhanSanPham(maSanPham, ten, hangSanXuat, gia, moTa));
        ghiVaoFileNhiPhan();
        danhSach.clear();
    }

    public static void hienThi() throws Exception {
        docFileNhiPhan();
        for (NhiPhanSanPham sanPham : danhSach) {
            System.out.println(sanPham.toString());
        }
    }

    public static void timKiem() throws Exception {
        System.out.print("Nhập tên sản phẩm bạn muốn tìm kiếm : ");
        String ten = scanner.nextLine();
        docFileNhiPhan();
        boolean check = true;
        for (NhiPhanSanPham sanPham : danhSach) {
            if (sanPham.getTenSanPham().equals(ten)) {
                check = false;
                System.out.println(sanPham.toString());
            }
        }
        if (check) System.out.println("Sản phẩm này không tồn tại !");
    }

    public static void ghiVaoFileNhiPhan() throws Exception {
        FileOutputStream fileOutput = new FileOutputStream(PATH);
        try {
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(danhSach);
            output.flush();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void docFileNhiPhan() throws Exception {
        FileInputStream fileInput = new FileInputStream(PATH);
        if (fileInput.available() > 0){
            try {
                ObjectInputStream input = new ObjectInputStream(fileInput);
                danhSach = (List<NhiPhanSanPham>) input.readObject();
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else System.out.println("Hiện tại file đang trống !");
    }
}
