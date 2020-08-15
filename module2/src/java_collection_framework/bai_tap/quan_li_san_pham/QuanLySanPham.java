package java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.*;

public class QuanLySanPham {
    public static Scanner scanner = new Scanner(System.in);
    public static List<SanPham> listSanPham = new ArrayList<>();
    //public static String thongBao = "";

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
        int soLuong;
        do {
            System.out.print("Nhập số lượng sản phẩm muốn thêm : ");
            String nhap = scanner.nextLine();
            if (kiemTraNhapSoNguyen(nhap)) {
                soLuong = Integer.parseInt(nhap);
                break;
            } else System.out.println("Số lượng không hợp lí !");
        } while (true);
        for (int i = 0; i < soLuong; i++) {
            listSanPham.add(new SanPham(tenSanPham(), giaSanPham()));
            System.out.print("Thêm sản phẩm thành công !");
            if (i < soLuong - 1) {
                System.out.println(" Nhập thông tin sản phẩm tiếp theo :");
            }
        }
    }

    public static void sua() {
        if (kiemTraList().equals("Ok")) {
            System.out.print("Nhập id sản phẩm bạn muốn sửa : ");
            String nhap = scanner.nextLine();
            if (kiemTraID(nhap) > -1) {
                SanPham sanPham = listSanPham.get(kiemTraID(nhap));
                sanPham.setTenSanPham(tenSanPham());
                sanPham.setGiaSanPham(giaSanPham());
                System.out.print("Sửa thông tin sản phẩm thành công !");
            } else System.out.print("Id không hợp lệ ! Hiện tại danh sách có " + listSanPham.size() + " sản phẩm !");
//            System.out.print("Nhập tên sản phẩm bạn muốn sửa : ");
//            String tenBandau = scanner.nextLine();
//            if (timKiem(tenBandau).equals(thongBao)) {
//                System.out.println(thongBao);
//            } else {
//                SanPham sanPham = (SanPham) timKiem(tenBandau);
//                sanPham.setTenSanPham(tenSanPham());
//                sanPham.setGiaSanPham(giaSanPham());
//                System.out.println("Sửa thông tin sản phẩm thành công !");
//            }
        } else System.out.print(kiemTraList());
    }

    public static void xoa() {
        if (kiemTraList().equals("Ok")) {
            System.out.print("Nhập id sản phẩm bạn muốn xóa : ");
            String nhap = scanner.nextLine();
            if (kiemTraID(nhap) > -1) {
                listSanPham.remove(kiemTraID(nhap));
                System.out.print("Xóa sản phẩm thành công !");
            } else System.out.print("Id không hợp lệ ! Hiện tại danh sách có " + listSanPham.size() + " sản phẩm !");
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
        } else System.out.print(kiemTraList());
    }

    public static Object hienThi() {
        if (kiemTraList().equals("Ok")) {
            return "Danh sách sản phẩm : " + listSanPham;
        } else return kiemTraList();
    }

//    public static Object timKiem(String ten) {
//        if (kiemTraList().equals("Ok")) {
//            for (SanPham sanPham : listSanPham) {
//                if (ten.equals(sanPham.getTenSanPham())) {
//                    System.out.print("Thông tin sản phẩm bạn cần tìm là : ");
//                    return sanPham;
//                }
//            }
//            thongBao = "Sản phẩm này không có trong danh sách !";
//            return thongBao;
//        } else return kiemTraList();
//    }

    public static Object timKiem() {
        if (kiemTraList().equals("Ok")) {
            System.out.print("Nhập tên sản phẩm bạn muốn tìm : ");
            String ten = scanner.nextLine();
            for (SanPham sanPham : listSanPham) {
                if (ten.equals(sanPham.getTenSanPham())) {
                    return "Thông tin sản phẩm bạn cần tìm là : " + sanPham;
                }
            }
            return "Sản phẩm này không có trong danh sách !";
        } else return kiemTraList();
    }

    public static void sapXep() {
        if (kiemTraList().equals("Ok")) {
            do {
                System.out.println("Menu :\n1. Giá giảm dần\n2. Giá tăng dần");
                System.out.print("Chọn cách bạn muốn sắp xếp : ");
                String nhapLuaChon = scanner.nextLine();
                if (kiemTraNhapSoNguyen(nhapLuaChon)) {
                    int luachon = Integer.parseInt(nhapLuaChon);
                    if (luachon == 1) {
                        System.out.print("Thứ tự sản phẩm sau khi sắp xếp giảm dần : ");
                        Collections.reverse(QuanLySanPham.sapXepTang());
                        System.out.print(listSanPham);
                        break;
                    } else if (luachon == 2) {
                        System.out.print("Thứ tự sản phẩm sau khi sắp xếp tăng dần : ");
                        System.out.print(sapXepTang());
                        break;
                    } else System.out.println("Lựa chọn không tồn tại !");
                } else System.out.println("Lựa chọn không hợp lệ !");
            } while (true);
        } else System.out.print(kiemTraList());
    }

    public static List<SanPham> sapXepTang() {
        listSanPham.sort(new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sanPham_1, SanPham sanPham_2) {
                if (sanPham_1.getGiaSanPham() > sanPham_2.getGiaSanPham()) {
                    return 1;
                } else if (sanPham_1.getGiaSanPham() == sanPham_2.getGiaSanPham()) return 0;
                else return -1;
            }
        });
        return listSanPham;
    }

    public static int kiemTraID(String id) {
        if (kiemTraNhapSoNguyen(id)) {
            int luaChon = Integer.parseInt(id) - 1;
            if (luaChon < listSanPham.size()) {
                return luaChon;
            }
        }
        return -1;
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
