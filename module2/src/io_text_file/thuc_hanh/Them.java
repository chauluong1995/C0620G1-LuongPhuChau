package io_text_file.thuc_hanh;

import java.io.IOException;
import java.util.Scanner;

public class Them {
    public static Scanner scanner = new Scanner(System.in);
    public static int bienDemID = 1;

    public static void themThongTinSanPham() {

    }

    public static void themSanPhamNhapKhau() throws IOException {
        String id = String.valueOf(bienDemID++);
        String maSanPham = Regex.kiemTraNhapChu("mã sản phẩm");
        String tenSanPham = Regex.kiemTraNhapChu("tên sản phẩm");
        String giaBanSanPham = Regex.kiemTraNhapSo("giá bán sản phẩm");
        String soLuong = Regex.kiemTraNhapSo("số lượng sản phẩm");
        String tenNhaSanXuat = Regex.kiemTraNhapChu("tên nhà sản xuất");
        String giaNhapKhau = Regex.kiemTraNhapSo("giá nhập khẩu");
        String tenTinhNhapVe = Regex.kiemTraNhapChu("tên tỉnh thành nhập về");
        String thue = Regex.kiemTraNhapSo("thuế nhập khẩu");
        SanPham sanPham = new SanPhamNhapKhau(id, maSanPham, tenSanPham, giaBanSanPham, soLuong, tenNhaSanXuat, giaNhapKhau, tenTinhNhapVe, thue);
        LuuFileCSV.ghiFile(sanPham);
    }

    public static void themSanPhamXuatKhau() throws IOException {
        String id = String.valueOf(bienDemID++);
        String maSanPham = Regex.kiemTraNhapChu(" mã sản phẩm");
        String tenSanPham = Regex.kiemTraNhapChu("tên sản phẩm");
        String giaBanSanPham = Regex.kiemTraNhapSo("giá bán sản phẩm");
        String soLuong = Regex.kiemTraNhapSo("số lượng sản phẩm");
        String tenNhaSanXuat = Regex.kiemTraNhapChu("tên nhà sản xuất");
        String giaXuatKhau = Regex.kiemTraNhapSo("giá xuất khẩu");
        String tenQuocGiaNhapSanPham = Regex.kiemTraNhapChu("tên quốc gia nhập sản phẩm");
        SanPham sanPham = new SanPhamXuatKhau(id, maSanPham, tenSanPham, giaBanSanPham, soLuong, tenNhaSanXuat, giaXuatKhau, tenQuocGiaNhapSanPham);
        LuuFileCSV.ghiFile(sanPham);
    }
}
