package bai_thi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner nhap = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n----- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -----\n1. Xem danh sách\n2. Thêm mới" +
                    "\n3. Cập nhật\n4. Xóa\n5. Tìm kiếm\n6. Đọc từ file\n7. Ghi vào file\n8. Thoát");
            System.out.print("Chọn chức năng : ");
            String nhapLuaChon = nhap.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        ThaoTacVoiDanhBa.hienThi();
                        break;
                    case 2:
                        ThaoTacVoiDanhBa.them();
                        break;
                    case 3:
                        ThaoTacVoiDanhBa.capNhat();
                        break;
                    case 4:
                        ThaoTacVoiDanhBa.xoa();
                        break;
                    case 5:
                        ThaoTacVoiDanhBa.timKiem();
                        break;
                    case 6:
                        ThaoTacVoiDanhBa.docTuFile();
                        break;
                    case 7:
                        ThaoTacVoiDanhBa.ghiVaoFile();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !\n");
                }
            } else System.out.println("Lựa chọn không hợp lệ !\n");
        } while (true);
    }
}
