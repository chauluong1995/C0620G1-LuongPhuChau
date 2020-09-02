package io_text_file.thuc_hanh;

import java.util.List;
import java.util.Scanner;

public class Them {
    public static Scanner scanner = new Scanner(System.in);

    public static int capNhatBienDem() {
        int bienDemID;
        List<SanPham> list = LuuFileCSV.docFile();
        if (list.isEmpty()) bienDemID = 1;
        else {
            int id = list.get(list.size() - 1).getId();
            bienDemID = id + 1;
        }
        return bienDemID;
    }

    public static void themSanPhamNhapKhau() {
        int id = capNhatBienDem();
        String maSanPham = Regex.kiemTraNhapChu("mã sản phẩm");
        String tenSanPham = Regex.kiemTraNhapChu("tên sản phẩm");
        String giaBanSanPham = Regex.kiemTraNhapSo("giá bán sản phẩm");
        String soLuong = Regex.kiemTraNhapSo("số lượng sản phẩm");
        String tenNhaSanXuat = Regex.kiemTraNhapChu("tên nhà sản xuất");
        String giaNhapKhau = Regex.kiemTraNhapSo("giá nhập khẩu");
        String tenTinhNhapVe = Regex.kiemTraNhapChu("tên tỉnh thành nhập về");
        String thue = Regex.kiemTraNhapSo("thuế nhập khẩu");
        SanPham sanPham = new Nhap(id, maSanPham, tenSanPham, giaBanSanPham, soLuong, tenNhaSanXuat, giaNhapKhau, tenTinhNhapVe, thue);
        LuuFileCSV.ghiFile(sanPham);
        System.out.println("Thêm sản phẩm nhập khẩu thành công !");
    }

    public static void themSanPhamXuatKhau() {
        int id = capNhatBienDem();
        String maSanPham = Regex.kiemTraNhapChu(" mã sản phẩm");
        String tenSanPham = Regex.kiemTraNhapChu("tên sản phẩm");
        String giaBanSanPham = Regex.kiemTraNhapSo("giá bán sản phẩm");
        String soLuong = Regex.kiemTraNhapSo("số lượng sản phẩm");
        String tenNhaSanXuat = Regex.kiemTraNhapChu("tên nhà sản xuất");
        String giaXuatKhau = Regex.kiemTraNhapSo("giá xuất khẩu");
        String tenQuocGiaNhapSanPham = Regex.kiemTraNhapChu("tên quốc gia nhập sản phẩm");
        SanPham sanPham = new Xuat(id, maSanPham, tenSanPham, giaBanSanPham, soLuong, tenNhaSanXuat, giaXuatKhau, tenQuocGiaNhapSanPham);
        LuuFileCSV.ghiFile(sanPham);
        System.out.println("Thêm sản phẩm xuất khẩu thành công !");
    }
}
