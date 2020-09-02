package io_text_file.thuc_hanh;

import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int luaChon;
        do {
            System.out.println("==================================\nMenu : \n1. Thêm sản phẩm\n2. Sửa thông tin sản phẩm\n3. Xóa sản phẩm" +
                    "\n4. Hiển thị danh sách sản phẩm\n5. Tìm kiếm sản phẩm\n6. Sắp xếp sản phẩm theo giá bán tăng dần\n7. Thoát" +
                    "\n==================================");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        themSanPham();
                        break;
                    case 2:
                        sua();
                        break;
                    case 3:
                        xoaSanPham();
                        break;
                    case 4:
                        hienThi();
                        break;
                    case 5:
                        timKiem();
                        break;
                    case 6:
                        sapXep();
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else System.out.println("Lựa chọn không hợp lệ !");
        } while (true);
    }

    public static void themSanPham() {
        int luaChon;
        do {
            System.out.println("==================================\nMenu : \n1. Thêm sản phẩm nhập khẩu\n2. Thêm sản phẩm xuất khẩu" +
                    "\n3. Quay về menu chính\n4. Thoát\n==================================");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        Them.themSanPhamNhapKhau();
                        break;
                    case 2:
                        Them.themSanPhamXuatKhau();
                        break;
                    case 3:
                        menu();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else System.out.println("Lựa chọn không hợp lệ !");
        } while (true);
    }

    public static void xoaSanPham() {
        List<SanPham> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            do {
                try {
                    System.out.print("Nhập mã sản phẩm cần xóa : ");
                    String nhap = scanner.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        if (nhap.equals(list.get(i).getMaSanPham())) {
                            do {
                                System.out.println("Bạn có thực sự muốn xóa sản phẩm này không ?!\nNhập Yes nếu muốn xóa !" +
                                        "\nNếu không thì nhập No :");
                                String chon = scanner.nextLine();
                                if (chon.equals("Yes")) {
                                    list.remove(i);
                                    LuuFileCSV.capNhatFile(list);
                                    hienThi();
                                    return;
                                }
                                if (chon.equals("No")) return;
                            } while (true);
                        }
                    }
                    throw new SPException();
                } catch (SPException n) {
                    n.getMassage();
                    System.out.println("Bạn có muốn quay về menu chính hay không ?! Ấn Enter để quay về ! Nhập No nếu muốn xóa tiếp !");
                    String luaChon = scanner.nextLine();
                    if (luaChon.equals("")) return;
                }
            } while (true);
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }

    public static void hienThi() {
        List<SanPham> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            int bienDem = 1;
            System.out.println("Danh sách các sản phẩm hiện tại là :");
            for (SanPham sanPham : list) {
                System.out.println("Sản phẩm " + bienDem + sanPham);
                bienDem++;
            }
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }

    public static void timKiem() {
        List<SanPham> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            System.out.print("Nhập mã hoặc tên của sản phẩm bạn muốn tìm kiếm : ");
            String nhap = scanner.nextLine();
            boolean kiemTra = true;
            int bienDem = 1;
            for (SanPham sanPham : list) {
                if (sanPham.getTenSanPham().contains(nhap) || sanPham.getMaSanPham().contains(nhap)) {
                    kiemTra = false;
                    System.out.println("Sản phẩm " + bienDem + sanPham);
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không tồn tại sản phẩm nào khớp với thông tin bạn nhập !");
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }

    public static void sapXep() {
        List<SanPham> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            list.sort(new SapXepSanPham());
            //Collections.reverse(list);
            int bienDem = 1;
            System.out.println("Danh sách sản phẩm được sắp xếp tăng dần theo giá bán là :");
            for (SanPham sanPham : list) {
                System.out.println("Sản phẩm " + bienDem + sanPham);
                bienDem++;
            }
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }

    public static void sua() {
        List<SanPham> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            boolean kiemTra = true;
            SanPham suaSanPham = null;
            System.out.print("Nhập mã chính xác của sản phẩm bạn muốn sửa : ");
            String nhap = scanner.nextLine();
            for (SanPham sanPham : list) {
                if (nhap.equals(sanPham.getMaSanPham())) {
                    kiemTra = false;
                    suaSanPham = sanPham;
                    break;
                }
            }
            if (kiemTra) System.out.println("Không tồn tại sản phẩm nào khớp với thông tin bạn nhập !");
            else {
                suaSanPham.setMaSanPham(Regex.kiemTraNhapChu("mã sản phẩm"));
                suaSanPham.setTenSanPham(Regex.kiemTraNhapChu("tên sản phẩm"));
                suaSanPham.setGiaSanPham(Regex.kiemTraNhapSo("giá bán sản phẩm"));
                suaSanPham.setSoLuongSanPham(Regex.kiemTraNhapSo("số lượng sản phẩm"));
                suaSanPham.setNhaSanXuat(Regex.kiemTraNhapChu("tên nhà sản xuất"));
                if (suaSanPham instanceof Nhap) {
                    ((Nhap) suaSanPham).setGiaNhapKhau(Regex.kiemTraNhapSo("giá nhập khẩu"));
                    ((Nhap) suaSanPham).setTinhThanhNhap(Regex.kiemTraNhapChu("tên tỉnh thành nhập về"));
                    ((Nhap) suaSanPham).setThueNhapKhau(Regex.kiemTraNhapSo("thuế nhập khẩu"));
                }
                if (suaSanPham instanceof Xuat) {
                    ((Xuat) suaSanPham).setGiaXuatKhau(Regex.kiemTraNhapSo("giá xuất khẩu"));
                    ((Xuat) suaSanPham).setQuocGiaNhapSanPham(Regex.kiemTraNhapChu("tên quốc gia nhập sản phẩm"));
                }
                LuuFileCSV.capNhatFile(list);
            }
            hienThi();
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }
}
