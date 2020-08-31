package io_text_file.thuc_hanh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Them {
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> list = new ArrayList<>();
    public static int id = 1;

    public static void themThongTinSanPham(){
        list.add(String.valueOf(id++));
        list.add(Regex.kiemTraNhapChu("mã sản phẩm"));
        list.add(Regex.kiemTraNhapChu("tên sản phẩm"));
        list.add(Regex.kiemTraNhapSo("giá bán sản phẩm"));
        list.add(Regex.kiemTraNhapSo("số lượng sản phẩm"));
        list.add(Regex.kiemTraNhapChu("tên nhà sản xuất"));
    }

    public static void themSanPhamNhapKhau() throws IOException {
        themThongTinSanPham();
        list.add(Regex.kiemTraNhapSo("giá nhập khẩu"));
        list.add(Regex.kiemTraNhapChu("tên tỉnh thành nhập về"));
        list.add(Regex.kiemTraNhapSo("thuế nhập khẩu"));
        LuuFileCSV.ghiFile(list);
        list.clear();
    }

    public static void themSanPhamXuatKhau() throws IOException {
        themThongTinSanPham();
        list.add(Regex.kiemTraNhapSo("giá xuất khẩu"));
        list.add(Regex.kiemTraNhapChu("tên quốc gia nhập sản phẩm"));
        LuuFileCSV.ghiFile(list);
        list.clear();
    }
}
