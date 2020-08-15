package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {
    public static Scanner scanner = new Scanner(System.in);
    public static List<SanPham> listSanPham = new ArrayList<>();
    public static String thongBao = "";

    public static Object kiemTraList() {
        if (listSanPham.isEmpty()) {
            return "Danh sách hiện tại chưa có sản phẩm nào !";
        } else return "Ok";
    }

    public static String tenSanPham() {
        String tenSanPham;
        do {
            System.out.print("Nhập tên mới cho sản phẩm : ");
            tenSanPham = scanner.nextLine();
            if (tenSanPham.equals("")) {
                System.out.println("Tên sản phẩm không được bỏ trống !");
            } else break;
        } while (true);
        return tenSanPham;
    }

    public static float giaSanPham() {
        float giaSanPham;
        do {
            System.out.print("Nhập giá mới cho sản phẩm : ");
            String nhapGia = scanner.nextLine();
            if (kiemTraNhapSoThuc(nhapGia)) {
                giaSanPham = Float.parseFloat(nhapGia);
                break;
            } else System.out.println("Giá sản phẩm không hợp lệ !");
        } while (true);
        return giaSanPham;
    }

    public static void them() {
        listSanPham.add(new SanPham(tenSanPham(), giaSanPham()));
        System.out.println("Thêm sản phẩm thành công !");
    }

    public static void sua() {
        if (kiemTraList().equals("Ok")) {
            System.out.print("Nhập tên sản phẩm bạn muốn sửa : ");
            String tenBandau = scanner.nextLine();
            if (timKiem(tenBandau).equals(thongBao)) {
                System.out.println(thongBao);
            } else {
                SanPham sanPham = (SanPham) timKiem(tenBandau);
                sanPham.setTenSanPham(tenSanPham());
                sanPham.setGiaSanPham(giaSanPham());
                System.out.println("Sửa thông tin sản phẩm thành công !");
            }
        } else System.out.println(kiemTraList());
    }

    public static void xoa() {
        if (kiemTraList().equals("Ok")) {
            System.out.print("Nhập id sản phẩm bạn muốn xóa : ");
            String nhap = scanner.nextLine();
            if (kiemTraNhapSoNguyen(nhap)) {
                int luaChon = Integer.parseInt(nhap);
                if (luaChon < listSanPham.size()) {
                    listSanPham.remove(luaChon);
                    System.out.println("Xóa sản phẩm thành công !");
                } else {
                    System.out.println("Id không tồn tại ! Hiện tại danh sách chỉ có " + listSanPham.size() + " sản phẩm !");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Id không hợp lệ !");
                scanner.nextLine();
            }
//            String ten = scanner.nextLine();
//            if (timKiem(ten).equals(thongBao)) {
//                System.out.println(thongBao);
//            } else {
//                for (int i = 0; i < listSanPham.size(); i++) {
//                    if (timKiem(ten).equals(listSanPham.get(i))) {
//                        listSanPham.remove(i);
//                        System.out.println("Xóa sản phẩm thành công !");
//                        break;
//                    }
//                }
//            }
        } else System.out.println(kiemTraList());
    }

    public static Object hienThi() {
        if (kiemTraList().equals("Ok")) {
            return "Danh sách sản phẩm : " + listSanPham;
        } else return kiemTraList();
    }

    public static Object timKiem(String ten) {
        if (kiemTraList().equals("Ok")) {
            for (SanPham sanPham : listSanPham) {
                if (ten.equals(sanPham.getTenSanPham())) {
                    return sanPham;
                }
            }
            thongBao = "Sản phẩm này không có trong danh sách !";
            return thongBao;
        } else return kiemTraList();
    }

    public static Object sapXep() {
        if (kiemTraList().equals("Ok")) {
            do {
                System.out.println("Menu :\n1. Sắp xếp giá theo thứ tự giảm dần\n2. Sắp xếp giá theo thứ tự tăng dần");
                System.out.print("Chọn cách bạn muốn sắp xếp : ");
                String nhapLuaChon = scanner.nextLine();
                if (kiemTraNhapSoNguyen(nhapLuaChon)) {
                    int luachon = Integer.parseInt(nhapLuaChon);
                    if (luachon == 1) {

                    } else if (luachon == 2) {

                    } else {
                        System.out.println("Lựa chọn không tồn tại !");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("Lựa chọn không hợp lệ !");
                    scanner.nextLine();
                }
            } while (true);
        } else return kiemTraList();
    }

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap) {
        return nhap.matches("\\d+(\\.\\d+)?");
    }

//    public static boolean kiemTraTrungTen(){
//
//    }
}
