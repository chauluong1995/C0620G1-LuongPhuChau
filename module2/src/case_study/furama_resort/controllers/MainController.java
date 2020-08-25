package case_study.furama_resort.controllers;

import java_collection_framework.bai_tap.quan_li_san_pham.QuanLySanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            if (QuanLySanPham.kiemTraNhapSoNguyen(nhapLuaChon)) {
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
            if (QuanLySanPham.kiemTraNhapSoNguyen(nhapLuaChon)) {
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
        System.out.print("Nhập ID : ");
        thongTin.add(scanner.nextLine());
        System.out.print("Nhập tên dịch vụ : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập diện tích sử dụng : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập chi phí thuê : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập kiểu thuê : ");
        thongTin.add(" " + scanner.nextLine());
    }

    public static void addNewVilla() {
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập diện tích hồ bơi : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập số tầng : ");
        thongTin.add(" " + scanner.nextLine());
        DocGhiFileCSV.ghiFile("Villa", thongTin);
        thongTin.clear();
    }

    public static void addNewHouse() {
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add("  " + scanner.nextLine());
        System.out.print("Nhập số tầng : ");
        thongTin.add(" " + scanner.nextLine());
        DocGhiFileCSV.ghiFile("House", thongTin);
        thongTin.clear();
    }

    public static void addNewRoom() {
        addNewInfoService();
        System.out.print("Nhập dịch vụ miễn phí đi kèm : ");
        thongTin.add(" " + scanner.nextLine());
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
            if (QuanLySanPham.kiemTraNhapSoNguyen(nhapLuaChon)) {
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
                        break;
                    case 5:
                        break;
                    case 6:
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
        System.out.println(thongTin.toString());
    }

    public static void showAllHouse() {
        DocGhiFileCSV.docFile("House");
    }

    public static void showAllRoom() {
        DocGhiFileCSV.docFile("Room");
    }
}
