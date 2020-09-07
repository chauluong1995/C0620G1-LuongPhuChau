package io_binary_file_serialization.thuc_hanh.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<DoiTuong> list = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int luaChon;
        do {
            System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ -----\n1. Xem danh sách\n2. Thêm mới" +
                    "\n3. Cập nhật\n4. Xóa\n5. Tìm kiếm\n6. Đọc từ file\n7. Ghi vào file\n8. Thoát");
            System.out.print("Chọn chức năng : ");
            String nhapLuaChon = scanner.nextLine();
            if (Validate.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        hienThi();
                        break;
                    case 2:
                        them();
                        break;
                    case 3:
                        capNhat();
                        break;
                    case 4:
                        xoa();
                        break;
                    case 5:
                        timKiem();
                        break;
                    case 6:
                        docTuFile();
                        break;
                    case 7:
                        ghiVaoFile();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !\n");
                }
            } else System.out.println("Lựa chọn không hợp lệ !\n");
        } while (true);
    }

    public static void hienThi() {
        if (list.isEmpty()) System.out.println("Trống !\n");
        else {
            int bienDem = 0;
            for (DoiTuong doiTuong : list) {
                if (bienDem % 5 == 0) {
                    System.out.println("Bạn có muốn thêm số mới hay không ! Gõ Y nếu muốn thêm ! Nếu không thì Enter xem tiếp !");
                    String nhap = scanner.nextLine();
                    if (nhap.equals("Y")) {
                        them();
                        break;
                    } else if (!nhap.equals("")) {
                        System.out.println("Lần sau nhớ nhấn Enter thôi ! Đừng gõ thêm phím nào nữa !\n");
                    }
                }
                System.out.println((bienDem + 1) + ". " + doiTuong.thongTin());
                bienDem++;
            }
        }
    }

    public static void them() {
        String sdt = Validate.kiemTraSDT();
        String nhom = Validate.kiemTraNhapChu("nhóm của danh bạ");
        String ten = Validate.kiemTraNhapChu("họ và tên");
        String gioiTinh = Validate.kiemTraNhapChu("giới tính");
        String diaChi = Validate.kiemTraNhapChu("địa chỉ");
        String ngaySinh = Validate.kiemTraNhapChu("ngày sinh");
        String email = Validate.kiemTraEmail();
        DoiTuong doiTuong = new DoiTuong(sdt, nhom, ten, gioiTinh, diaChi, ngaySinh, email);
        list.add(doiTuong);
        System.out.println("Thêm thành công !\n");
    }

    public static void capNhat() {
        if (list.isEmpty()) System.out.println("Trống !\n");
        else {
            DoiTuong doiTuong = null;
            do {
                System.out.print("Nhập sdt cần sửa : ");
                String sdt = scanner.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Không nhập thì khỏi sửa !\n");
                    break;
                }
                for (DoiTuong element : list) {
                    if (sdt.equals(element.getSdt())) {
                        doiTuong = element;
                        break;
                    }
                }
                if (doiTuong != null) break;
                else System.out.println("Không tìm thấy ! Đề nghị nhập lại !");
            } while (true);
            if (doiTuong != null) {
                String nhom = Validate.kiemTraNhapChu("nhóm của danh bạ");
                doiTuong.setNhom(nhom);
                String ten = Validate.kiemTraNhapChu("họ và tên");
                doiTuong.setTen(ten);
                String gioiTinh = Validate.kiemTraNhapChu("giới tính");
                doiTuong.setGioiTinh(gioiTinh);
                String diaChi = Validate.kiemTraNhapChu("địa chỉ");
                doiTuong.setDiaChi(diaChi);
                String ngaySinh = Validate.kiemTraNhapChu("ngày sinh");
                doiTuong.setNgaySinh(ngaySinh);
                String email = Validate.kiemTraEmail();
                doiTuong.setEmail(email);
                System.out.println("Cập nhật thành công !\n");
            }
        }
    }

    public static void xoa() {
        if (list.isEmpty()) System.out.println("Trống !\n");
        else {
            DoiTuong doiTuong = null;
            do {
                System.out.print("Nhập sdt cần xóa : ");
                String sdt = scanner.nextLine();
                if (sdt.equals("")) {
                    System.out.println("Không nhập thì khỏi xóa !\n");
                    break;
                }
                for (DoiTuong element : list) {
                    if (sdt.equals(element.getSdt())) {
                        doiTuong = element;
                        break;
                    }
                }
                if (doiTuong != null) break;
                else System.out.println("Không tìm thấy ! Đề nghị nhập lại !");
            } while (true);
            if (doiTuong != null) {
                System.out.println("Bạn có thực sự muốn xóa ?! Nếu muốn thì nhập Y ! Nếu nhập khác Y thì sẽ hủy lệnh xóa !");
                if (scanner.nextLine().equals("Y")) {
                    list.remove(doiTuong);
                    System.out.println("Xóa thành công !");
                } else System.out.println("Lệnh xóa đã được hủy !\n");
            }
        }
    }

    public static void timKiem() {
        if (list.isEmpty()) System.out.println("Trống !\n");
        else {
            boolean kiemTra = true;
            int bienDem = 1;
            System.out.print("Nhập thông tin cần tìm : ");
            String nhap = scanner.nextLine();
            for (DoiTuong doiTuong : list) {
                if (doiTuong.getSdt().contains(nhap) || doiTuong.getTen().contains(nhap)) {
                    kiemTra = false;
                    if (bienDem == 1) System.out.println("DB khớp với thông tin cần tìm là :");
                    System.out.println(bienDem + ". " + doiTuong.thongTin());
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không tìm thấy DB khớp với thông tin bạn nhập !\n");
        }
    }

    public static void docTuFile() {
        if (BoNho.xuat().isEmpty()) System.out.println("File trống !");
        System.out.println("Bạn có thực sự muốn cập nhật DB hay k ?! Nếu cập nhật toàn bộ bộ nhớ DB sẽ bị xóa !\n" +
                "Nhập Yes nếu muốn cập nhật ! Nếu không nhập Yes thì lệnh cập nhật sẽ được hủy !");
        if (scanner.nextLine().equals("Yes")) {
            list = BoNho.xuat();
            System.out.println("Cập nhật thành công !");
            hienThi();
        } else System.out.println("Lệnh cập nhật đã được hủy !\n");
    }

    public static void ghiVaoFile() {
        if (list.isEmpty()) System.out.println("DB trống !");
        System.out.println("Bạn có thực sự muốn cập nhật file hay k ?! Nếu cập nhật toàn bộ nội dung file sẽ bị xóa !\n" +
                "Nhập Yes nếu muốn cập nhật ! Nếu không nhập Yes thì lệnh cập nhật sẽ được hủy !");
        if (scanner.nextLine().equals("Yes")) {
            BoNho.luu(list);
            System.out.println("Cập nhật thành công !");
        } else System.out.println("Lệnh cập nhật đã được hủy !\n");
    }
}
