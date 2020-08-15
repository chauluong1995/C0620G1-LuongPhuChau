package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {
    public static Scanner scanner = new Scanner(System.in);
    public static List<SanPham> listSanPham = new ArrayList<>();
    public static String thongBao = "";

    public static Object kiemTraTrong(){
        if (listSanPham.isEmpty()){
            return "Danh sách hiện tại chưa có sản phẩm nào !";
        }else return "Ok";
    }

    public static void them() {
        String tenSanPham;
        int giaSanPham;
        do {
            System.out.print("Nhập tên sản phẩm : ");
            tenSanPham = scanner.nextLine();
            if (tenSanPham.equals("")) {
                System.out.println("Tên sản phẩm không được bỏ trống !");
            } else break;
        } while (true);
        do {
            System.out.print("Nhập giá sản phẩm : ");
            giaSanPham = scanner.nextInt();
            scanner.skip("\\R");
            if (giaSanPham < 0) {
                System.out.println("Giá sản phẩm không hợp lệ !");
            } else break;
        } while (true);
        listSanPham.add(new SanPham(tenSanPham, giaSanPham));
        System.out.println("Thêm sản phẩm thành công !");
    }

    public static void sua() {
        if (kiemTraTrong().equals("Ok")){
            String tenBandau;
            do {
                System.out.print("Nhập tên sản phẩm bạn muốn sửa : ");
                tenBandau = scanner.nextLine();
                if (tenBandau.equals("")) {
                    System.out.println("Tên sản phẩm không được bỏ trống !");
                } else break;
            } while (true);
            if (timKiem(tenBandau).equals(thongBao)){
                System.out.println(thongBao);
            }else {

            }
        }else System.out.println(kiemTraTrong());
    }

    public static Object timKiem(String ten) {
        for (SanPham sanPham : listSanPham) {
            if (ten.equals(sanPham.getTenSanPham())) {
                return sanPham;
            }
        }
        thongBao = "Sản phẩm này không có trong danh sách !";
        return thongBao;
    }

    public static List<SanPham> hienThi() {
        return listSanPham;
    }
}
