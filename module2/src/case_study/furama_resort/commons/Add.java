package case_study.furama_resort.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add {
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> thongTin = new ArrayList<>();

    public static void addNewInfoService() {
        thongTin.add(Regex.kiemTraDienTich("sử dụng"));
        thongTin.add(Regex.kiemTraChiPhiThue());
        thongTin.add(Regex.kiemTraSoLuongNguoiToiDa());
        System.out.print("Nhập kiểu thuê : ");
        thongTin.add(Regex.chuanHoaDuLieu(scanner.nextLine()));
    }

    public static void addNewVilla() throws IOException {
        thongTin.add(Regex.kiemTraID("VL"));
        thongTin.add(Regex.kiemTraTenDichVu("Villa"));
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(Regex.chuanHoaDuLieu(scanner.nextLine()));
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add(Regex.chuanHoaDuLieu(scanner.nextLine()));
        thongTin.add(Regex.kiemTraDienTich("hồ bơi"));
        thongTin.add(Regex.kiemTraSoTang());
        DocGhiFileCSV.ghiFile("Villa", thongTin);
        System.out.println("Thêm thành công !");
        thongTin.clear();
    }

    public static void addNewHouse() throws IOException {
        thongTin.add(Regex.kiemTraID("HO"));
        thongTin.add(Regex.kiemTraTenDichVu("House"));
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(Regex.chuanHoaDuLieu(scanner.nextLine()));
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add(Regex.chuanHoaDuLieu(scanner.nextLine()));
        thongTin.add(Regex.kiemTraSoTang());
        DocGhiFileCSV.ghiFile("House", thongTin);
        System.out.println("Thêm thành công !");
        thongTin.clear();
    }

    public static void addNewRoom() throws IOException {
        thongTin.add(Regex.kiemTraID("RO"));
        thongTin.add(Regex.kiemTraTenDichVu("Room"));
        addNewInfoService();
        thongTin.add(Regex.kiemTraDichVuDiKem());
        DocGhiFileCSV.ghiFile("Room", thongTin);
        System.out.println("Thêm thành công !");
        thongTin.clear();
    }

    public static void addNewCusTomer() throws IOException {
        thongTin.add(Regex.kiemTraTen());
        thongTin.add(Regex.kiemTraNgaySinh());
        thongTin.add(Regex.kiemTraGioiTinh());
        thongTin.add(Regex.kiemTraCMND());
        System.out.print("Nhập số điện thoại : ");
        thongTin.add(scanner.nextLine());
        thongTin.add(Regex.kiemTraEmail());
        System.out.print("Nhập loại khách : ");
        thongTin.add(scanner.nextLine());
        System.out.print("Nhập địa chỉ : ");
        thongTin.add(scanner.nextLine());
        DocGhiFileCSV.ghiFile("Customer", thongTin);
        System.out.println("Thêm thành công !");
        thongTin.clear();
    }

//        public static void addNewVilla() throws IOException {
//        String id = nhapID("VL");
//        String tenDichVu = nhapTenDichVu("Villa");
//        String dienTichSuDung= nhapDienTichSuDung();
//        String chiPhiThue = nhapChiPhiThue();
//        String soLuongNguoiToiDa = soLuongNguoiToiDa();
//        System.out.print("Nhập kiểu thuê : ");
//        String kieuThue = chuanHoaDuLieu(scanner.nextLine());
//        System.out.print("Nhập tiêu chuẩn phòng : ");
//        String tieuChuanPhong = chuanHoaDuLieu(scanner.nextLine());
//        System.out.print("Nhập mô tả tiện nghi khác : ");
//        String moTa = scanner.nextLine();
//        String dienTichHoBoi = nhapDienTichHoBoi();
//        String soTang = soTang();
//        Villa villa = new Villa(id,tenDichVu,dienTichSuDung,chiPhiThue,soLuongNguoiToiDa,kieuThue,tieuChuanPhong,moTa,dienTichHoBoi,soTang);
//        thongTin.add(villa);
//        DocGhiFileCSV.ghiFile("Villa", thongTin);
//        thongTin.clear();
//    }
}
