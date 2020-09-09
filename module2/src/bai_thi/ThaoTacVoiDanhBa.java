package bai_thi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThaoTacVoiDanhBa {
    public static Scanner nhap = new Scanner(System.in);
    public static List<DanhBa> boNho = new ArrayList<>();

    public static void hienThi() {
        if (boNho.isEmpty()) System.out.println("\nTrống !\n");
        else {
            int bienDem = 0;
            for (DanhBa danhBa : boNho) {
                if (bienDem % 5 == 0) {
                    System.out.println("\nBạn có muốn thêm số điện thoại mới hay không ! " +
                            "Gõ Y nếu muốn thêm ! Nếu không thì Enter để xem tiếp danh bạ !");
                    String luaChon = nhap.nextLine();
                    if (luaChon.equals("Y")) {
                        them();
                        break;
                    } else if (!luaChon.equals("")) {
                        System.out.println("\nLần sau nhớ nhấn Enter thôi ! Đừng gõ thêm phím nào nữa !\n");
                    }
                }
                System.out.println((bienDem + 1) + ". " + danhBa.thongTin());
                bienDem++;
            }
        }
    }

    public static void them() {
        String sdt = Regex.kiemTraSoDienThoai();
        String nhom = Regex.kiemTraNhapThongTin("nhóm của danh bạ");
        String ten = Regex.kiemTraNhapThongTin("họ và tên");
        String gioiTinh = Regex.kiemTraNhapThongTin("giới tính");
        String diaChi = Regex.kiemTraNhapThongTin("địa chỉ");
        String ngaySinh = Regex.kiemTraNhapThongTin("ngày sinh");
        String email = Regex.kiemTraEmail();
        DanhBa danhBa = new DanhBa(sdt, nhom, ten, gioiTinh, diaChi, ngaySinh, email);
        boNho.add(danhBa);
        System.out.println("\nThêm thành công !\n");
    }

    public static void capNhat() {
        if (boNho.isEmpty()) System.out.println("\nTrống !\n");
        else {
            DanhBa danhBa = null;
            do {
                System.out.print("Nhập số điện thoại cần sửa : ");
                String soDienThoai = nhap.nextLine();
                if (soDienThoai.equals("")) {
                    System.out.println("\nKhông nhập thì hủy lệnh sửa !\n");
                    break;
                }
                for (DanhBa phanTu : boNho) {
                    if (soDienThoai.equals(phanTu.getSoDienThoai())) {
                        danhBa = phanTu;
                        break;
                    }
                }
                if (danhBa != null) break;
                else System.out.println("\nKhông tìm thấy số điện thoại bạn nhập ! Đề nghị nhập lại !");
            } while (true);
            if (danhBa != null) {
                String nhom = Regex.kiemTraNhapThongTin("nhóm của danh bạ");
                danhBa.setNhom(nhom);
                String ten = Regex.kiemTraNhapThongTin("họ và tên");
                danhBa.setTen(ten);
                String gioiTinh = Regex.kiemTraNhapThongTin("giới tính");
                danhBa.setGioiTinh(gioiTinh);
                String diaChi = Regex.kiemTraNhapThongTin("địa chỉ");
                danhBa.setDiaChi(diaChi);
                String ngaySinh = Regex.kiemTraNhapThongTin("ngày sinh");
                danhBa.setNgaySinh(ngaySinh);
                String email = Regex.kiemTraEmail();
                danhBa.setEmail(email);
                System.out.println("\nCập nhật thành công !\n");
            }
        }
    }

    public static void xoa() {
        if (boNho.isEmpty()) System.out.println("\nTrống !\n");
        else {
            DanhBa danhBa = null;
            do {
                System.out.print("Nhập số điện thoại cần xóa : ");
                String soDienThoai = nhap.nextLine();
                if (soDienThoai.equals("")) {
                    System.out.println("\nKhông nhập thì hủy lệnh xóa !\n");
                    break;
                }
                for (DanhBa phanTu : boNho) {
                    if (soDienThoai.equals(phanTu.getSoDienThoai())) {
                        danhBa = phanTu;
                        break;
                    }
                }
                if (danhBa != null) break;
                else System.out.println("\nKhông tìm thấy số điện thoại bạn nhập ! Đề nghị nhập lại !");
            } while (true);
            if (danhBa != null) {
                System.out.println("Bạn có thực sự muốn xóa không ?! Nếu muốn thì nhập Y ! Nếu nhập khác Y thì sẽ hủy lệnh xóa !");
                if (nhap.nextLine().equals("Y")) {
                    boNho.remove(danhBa);
                    System.out.println("\nXóa thành công !");
                } else System.out.println("\nLệnh xóa đã được hủy !\n");
            }
        }
    }

    public static void timKiem() {
        if (boNho.isEmpty()) System.out.println("\nTrống !\n");
        else {
            boolean kiemTra = true;
            int bienDem = 1;
            System.out.println("Nhập thông tin cần tìm : (Chỉ cần nhập gần đúng số điện thoại hoặc họ tên)");
            String thongTin = nhap.nextLine();
            for (DanhBa phanTu : boNho) {
                if (phanTu.getSoDienThoai().contains(thongTin) || phanTu.getTen().contains(thongTin)) {
                    kiemTra = false;
                    if (bienDem == 1) System.out.println("Danh bạ khớp với thông tin cần tìm là :");
                    System.out.println(bienDem + ". " + phanTu.thongTin());
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không tìm thấy danh bạ khớp với thông tin bạn nhập !\n");
        }
    }

    public static void docTuFile() {
        List<DanhBa> noiDungFile = DocGhiFileCSV.xuatTuFile();
        if (noiDungFile.isEmpty()) System.out.println("\nFile trống hoặc không tồn tại !");
        System.out.println("\nBạn có thực sự muốn cập nhật danh bạ từ File hay không ?! " +
                "Nếu cập nhật toàn bộ bộ nhớ danh bạ ban đầu sẽ bị xóa và thay bằng thông tin trong File !\n" +
                "Nhập Yes nếu muốn cập nhật ! Nếu không nhập Yes thì lệnh cập nhật sẽ được hủy !");
        String luaChon = nhap.nextLine();
        if (luaChon.equals("Yes")) {
            boNho = noiDungFile;
            System.out.println("\nCập nhật danh bạ từ File thành công !\n");
            hienThi();
        } else System.out.println("Lệnh cập nhật danh bạ từ File đã được hủy !\n");
    }

    public static void ghiVaoFile() {
        if (boNho.isEmpty()) System.out.println("Danh bạ đang trống !");
        System.out.println("\nBạn có thực sự muốn cập nhật File hay không ?! " +
                "Nếu cập nhật toàn bộ nội dung File sẽ bị xóa và thay bằng nội dung trong bộ nhớ !\n" +
                "Nhập Yes nếu muốn cập nhật ! Nếu không nhập Yes thì lệnh cập nhật sẽ được hủy !");
        String luaChon = nhap.nextLine();
        if (luaChon.equals("Yes")) {
            DocGhiFileCSV.ghiVaoFile(boNho);
            System.out.println("\nCập nhật File từ danh bạ thành công !\n");
        } else System.out.println("Lệnh cập nhật File từ danh bạ đã được hủy !\n");
    }
}
