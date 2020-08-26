package case_study.furama_resort.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> thongTin = new ArrayList<>();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Add New Services\n2. Show Services\n3. Add New Customer" +
                    "\n4. Show Information of Customer\n5. Add New Booking\n6. Show Information of Employee\n7. Exit");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        addNewServices();
                        break;
                    case 2:
                        showServices();
                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    case 5:
//                        break;
//                    case 6:
//                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ !");
            }
        } while (true);
    }

    public static void addNewServices() {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Add New Villa\n2. Add New House\n3. Add New Room\n4. Back to Menu\n5. Exit");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        addNewVilla();
                        break;
                    case 2:
                        addNewHouse();
                        break;
                    case 3:
                        addNewRoom();
                        break;
                    case 4:
                        displayMainMenu();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ !");
            }
        } while (true);
    }

    public static void addNewInfoService() {
        thongTin.add(nhapDienTichSuDung());
        thongTin.add(nhapChiPhiThue());
        thongTin.add(soLuongNguoiToiDa());
        System.out.print("Nhập kiểu thuê : ");
        thongTin.add(chuanHoaDuLieu(scanner.nextLine()));
    }

    public static void addNewVilla() {
        thongTin.add(nhapID("VL"));
        thongTin.add(nhapTenDichVu("Villa"));
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(chuanHoaDuLieu(scanner.nextLine()));
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add(" " + scanner.nextLine());
        thongTin.add(nhapDienTichHoBoi());
        thongTin.add(soTang());
        DocGhiFileCSV.ghiFile("Villa", thongTin);
        thongTin.clear();
    }

    public static void addNewHouse() {
        thongTin.add(nhapID("HO"));
        thongTin.add(nhapTenDichVu("House"));
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(chuanHoaDuLieu(scanner.nextLine()));
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add("  " + scanner.nextLine());
        thongTin.add(soTang());
        DocGhiFileCSV.ghiFile("House", thongTin);
        thongTin.clear();
    }

    public static void addNewRoom() {
        thongTin.add(nhapID("RO"));
        thongTin.add(nhapTenDichVu("Room"));
        addNewInfoService();
        thongTin.add(dichVuDiKem());
        DocGhiFileCSV.ghiFile("Room", thongTin);
        thongTin.clear();
    }

    public static void showServices() {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Show all Villa\n2. Show all House\n3. Show all Room\n4. Show All Name Villa Not Duplicate" +
                    "\n5. Show All Name House Not Duplicate\n6. Show All Name Room Not Duplicate\n7. Back to menu\n8. Exit");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        showAllVilla();
                        break;
                    case 2:
                        showAllHouse();
                        break;
                    case 3:
                        showAllRoom();
                        break;
                    case 4:
                        showAllNameVillaNotDuplicate();
                        break;
                    case 5:
                        showAllNameHouseNotDuplicate();
                        break;
                    case 6:
                        showAllNameRoomNotDuplicate();
                        break;
                    case 7:
                        displayMainMenu();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ !");
            }
        } while (true);
    }

    public static void showAllVilla() {
        DocGhiFileCSV.docFile("Villa");
        for (int i = 0; i < thongTin.size(); i++) {
            if (i > 0) System.out.println("Villa " + i + " : " + thongTin.get(i));
            else System.out.println(thongTin.get(i));
        }
        thongTin.clear();
    }

    public static void showAllHouse() {
        DocGhiFileCSV.docFile("House");
        for (int i = 0; i < thongTin.size(); i++) {
            if (i > 0) System.out.println("House " + i + " : " + thongTin.get(i));
            else System.out.println(thongTin.get(i));
        }
        thongTin.clear();
    }

    public static void showAllRoom() {
        DocGhiFileCSV.docFile("Room");
        for (int i = 0; i < thongTin.size(); i++) {
            if (i > 0) System.out.println("Room " + i + " : " + thongTin.get(i));
            else System.out.println(thongTin.get(i));
        }
        thongTin.clear();
    }

    public static void showAllNameVillaNotDuplicate() {

    }

    public static void showAllNameHouseNotDuplicate() {

    }

    public static void showAllNameRoomNotDuplicate() {

    }

    public static String nhapID(String loaiDichVu) {
        final String ID_REGEX = "^SV" + loaiDichVu + "-\\d{4}$";
        String id;
        Matcher matcher;
        do {
            Pattern pattern = Pattern.compile(ID_REGEX);
            System.out.print("Nhập id : ");
            id = scanner.nextLine();
            matcher = pattern.matcher(id);
            if (matcher.matches()) break;
            else {
                System.out.println("ID không hợp lệ ! Định dạng ID hợp lệ : SVXX-YYYY\nVới YYYY là các số từ 0-9\nVà XX là :" +
                        "\nNếu Villa thì XX sẽ là VL" +
                        "\nNếu House thì XX sẽ là HO" +
                        "\nNếu Room thì XX sẽ là RO");
            }
        } while (true);
        return id;
    }

    public static String nhapTenDichVu(String tenDungCuaDichVu) {
        String nhapTen;
        do {
            System.out.print("Nhập tên dịch vụ : ");
            nhapTen = scanner.nextLine();
            if (nhapTen.equals(tenDungCuaDichVu)) break;
            else
                System.out.println("Tên dịch vụ không hợp lệ !\nNếu Villa thì sẽ là Villa\nNếu House thì sẽ là House\nNếu Room thì sẽ là Room");
        } while (true);
        return nhapTen;
    }

    public static String nhapDienTichSuDung() {
        String dienTichSuDung;
        do {
            System.out.print("Nhập diện tích sử dụng : ");
            dienTichSuDung = scanner.nextLine();
            if (kiemTraNhapSoThuc(dienTichSuDung) && Float.parseFloat(dienTichSuDung) > 30) break;
            else System.out.println("Diện tích sử dụng phải là số thực lớn hơn 30 !");
        } while (true);
        return dienTichSuDung;
    }

    public static String nhapDienTichHoBoi() {
        String dienTichHoBoi;
        do {
            System.out.print("Nhập diện tích hồ bơi : ");
            dienTichHoBoi = scanner.nextLine();
            if (kiemTraNhapSoThuc(dienTichHoBoi) && Float.parseFloat(dienTichHoBoi) > 30) break;
            else System.out.println("Diện tích hồ bơi phải là số thực lớn hơn 30 !");
        } while (true);
        return dienTichHoBoi;
    }

    public static String nhapChiPhiThue() {
        String chiPhiThue;
        do {
            System.out.print("Nhập chi phí thuê : ");
            chiPhiThue = scanner.nextLine();
            if (kiemTraNhapSoThuc(chiPhiThue) && Float.parseFloat(chiPhiThue) > 0) break;
            else System.out.println("Chi phí thuê phải là số dương !");
        } while (true);
        return chiPhiThue;
    }

    public static String soLuongNguoiToiDa() {
        String soLuongNguoiToiDa;
        do {
            System.out.print("Nhập số lượng người tối đa : ");
            soLuongNguoiToiDa = scanner.nextLine();
            if (kiemTraNhapSoNguyen(soLuongNguoiToiDa) && Integer.parseInt(soLuongNguoiToiDa) > 0 && Integer.parseInt(soLuongNguoiToiDa) < 20)
                break;
            else System.out.println("Số lượng người tối đa phải > 0 và nhỏ hơn < 20 !");
        } while (true);
        return soLuongNguoiToiDa;
    }

    public static String dichVuDiKem() {
        String dichVuDiKem;
        do {
            System.out.print("Nhập dịch vụ miễn phí đi kèm : ");
            dichVuDiKem = scanner.nextLine();
            if (dichVuDiKem.matches("^massage$|^karaoke$|^food$|^drink$|^car$")) break;
            else System.out.println("Dịch vụ đi kèm phải là 1 trong các giá trị: massage, karaoke, food, drink, car !");
        } while (true);
        return dichVuDiKem;
    }

    public static String soTang() {
        String soTang;
        do {
            System.out.print("Nhập số tầng : ");
            soTang = scanner.nextLine();
            if (kiemTraNhapSoNguyen(soTang) && Integer.parseInt(soTang) > 0) break;
            else System.out.println("Số tầng phải là số nguyên dương !");
        } while (true);
        return soTang;
    }

    public static String chuanHoaDuLieu(String duLieu) {
        duLieu = duLieu.toLowerCase();
        duLieu = Character.toUpperCase(duLieu.charAt(0)) + duLieu.substring(1);
        return duLieu;
    }

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap) {
        return nhap.matches("\\d+(\\.\\d+)?");
    }
}
