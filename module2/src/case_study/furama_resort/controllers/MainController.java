package case_study.furama_resort.controllers;

import java_collection_framework.bai_tap.quan_li_san_pham.QuanLySanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> thongTin = new ArrayList<>();

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
//                    case 2:
//                        break;
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
        thongTin.add("  " + scanner.nextLine());
        System.out.print("Nhập diện tích hồ bơi : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập số tầng : ");
        thongTin.add(" " + scanner.nextLine());
        DocGhiFileCSV.ghiFile("Villa", thongTin);
        thongTin.clear();
    }

    public static void addNewHouse(){
        addNewInfoService();
        System.out.print("Nhập tiêu chuẩn phòng : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập mô tả tiện nghi khác : ");
        thongTin.add(" " + scanner.nextLine());
        System.out.print("Nhập số tầng : ");
        thongTin.add(" " + scanner.nextLine());
        DocGhiFileCSV.ghiFile("House", thongTin);
        thongTin.clear();
    }

    public static void addNewRoom(){
        addNewInfoService();
        System.out.print("Nhập dịch vụ miễn phí đi kèm : ");
        thongTin.add(" " + scanner.nextLine());
        DocGhiFileCSV.ghiFile("Room", thongTin);
        thongTin.clear();
    }
}
