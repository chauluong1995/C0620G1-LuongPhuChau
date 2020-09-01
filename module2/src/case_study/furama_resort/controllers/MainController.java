package case_study.furama_resort.controllers;

import case_study.furama_resort.commons.Add;
import case_study.furama_resort.commons.Booking;
import case_study.furama_resort.commons.DocGhiFileCSV;
import case_study.furama_resort.commons.Regex;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.views.Show;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        kiemTraFile();

        int luaChon;
        do {
            System.out.println("Menu : \n1. Add New Services\n2. Show Services\n3. Add New Customer" +
                    "\n4. Show Information of Customer\n5. Add New Booking\n6. Show Information of Employee" +
                    "\n7. Buy Movie Tickets\n8. Find Information Employee \n9. Exit");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        addNewServices();
                        break;
                    case 2:
                        showServices();
                        break;
                    case 3:
                        Add.addNewCusTomer();
                        break;
                    case 4:
                        Show.showInformationCustomers();
                        break;
                    case 5:
                        addNewBooking();
                        break;
                    case 6:
                        Show.showInformationOfEmployee();
                        break;
                    case 7:
                        Booking.buyMovieTickets();
                        break;
                    case 8:
                        Show.findInformationEmployee();
                        break;
                    case 9:
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
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        Add.addNewVilla();
                        break;
                    case 2:
                        Add.addNewHouse();
                        break;
                    case 3:
                        Add.addNewRoom();
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

    public static void showServices() {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Show all Villa\n2. Show all House\n3. Show all Room\n4. Show All Name Villa Not Duplicate" +
                    "\n5. Show All Name House Not Duplicate\n6. Show All Name Room Not Duplicate\n7. Back to menu\n8. Exit");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        Show.showAllVilla();
                        break;
                    case 2:
                        Show.showAllHouse();
                        break;
                    case 3:
                        Show.showAllRoom();
                        break;
                    case 4:
                        Show.showAllNameVillaNotDuplicate();
                        displayMainMenu();
                        break;
                    case 5:
                        Show.showAllNameHouseNotDuplicate();
                        displayMainMenu();
                        break;
                    case 6:
                        Show.showAllNameRoomNotDuplicate();
                        displayMainMenu();
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

    public static void addNewBooking() {
        List<Customer> list = Show.showInformationCustomers();
        if (!list.isEmpty()) {
            int soThuTu;
            do {
                System.out.print("Chọn số thứ tự Customer muốn booking : ");
                String nhap = scanner.nextLine();
                if (Regex.kiemTraNhapSoNguyen(nhap)) {
                    soThuTu = Integer.parseInt(nhap);
                    if (soThuTu > 0 && soThuTu <= list.size()) break;
                }
                System.out.println("Lựa chọn của bạn không hợp lệ !");
            } while (true);

            Customer customer = list.get(soThuTu - 1);

            int luaChon;
            do {
                System.out.println("Menu : \n1. Booking Villa\n2. Booking House\n3. Booking Room\n4. Back to Menu\n5. Exit");
                System.out.print("Chọn thao tác muốn thực hiện : ");
                String nhapLuaChon = scanner.nextLine();
                if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                    luaChon = Integer.parseInt(nhapLuaChon);
                    switch (luaChon) {
                        case 1:
                            if (Booking.bookingVilla(customer)) {
                                DocGhiFileCSV.ghiFileBooking(customer);
                                System.out.println("Booking Villa thành công !");
                            }
                            displayMainMenu();
                            break;
                        case 2:
                            if (Booking.bookingHouse(customer)) {
                                DocGhiFileCSV.ghiFileBooking(customer);
                                System.out.println("Booking House thành công !");
                            }
                            displayMainMenu();
                            break;
                        case 3:
                            if (Booking.bookingRoom(customer)) {
                                DocGhiFileCSV.ghiFileBooking(customer);
                                System.out.println("Booking Room thành công !");
                            }
                            displayMainMenu();
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
    }

    public static void kiemTraFile() {
        File fileVilla = new File("src/case_study/furama_resort/data/Villa.csv");
        if (!fileVilla.isFile()) DocGhiFileCSV.lamMoiFile("Villa");

        File fileHouse = new File("src/case_study/furama_resort/data/House.csv");
        if (!fileHouse.isFile()) DocGhiFileCSV.lamMoiFile("House");

        File fileRoom = new File("src/case_study/furama_resort/data/Room.csv");
        if (!fileRoom.isFile()) DocGhiFileCSV.lamMoiFile("Room");

        File fileCustomer = new File("src/case_study/furama_resort/data/Customer.csv");
        if (!fileCustomer.isFile()) DocGhiFileCSV.lamMoiFile("Customer");

        File fileEmployee = new File("src/case_study/furama_resort/data/Employee.csv");
        if (!fileEmployee.isFile()) {
            try {
                if (fileEmployee.createNewFile()) System.out.println("Tạo file Employee.csv thành công !");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }

        File fileBooking = new File("src/case_study/furama_resort/data/Booking.csv");
        if (!fileBooking.isFile()) {
            try {
                if (fileBooking.createNewFile()) System.out.println("Tạo file Booking.csv thành công !");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
    //Mã số nhân viên,Họ Tên,Tuổi,Địa chỉ
    //003,Nguyễn Văn A,22,Đà Nẵng
    //002,Lê Thị B,21,Quảng Bình
    //001,Trần Văn C,22,Quảng Trị
    //004,Bùi Văn D,22,Huế
    //010,Huỳnh Văn E,23,Quảng Nam
    //006,Lý Văn H,22,Quảng Ngãi
    //009,Đỗ Thị K,21,Bình Định
    //008,Hồ Thị M,21,Phú Yên
    //007,Phạm Văn N,23,Khánh Hòa
    //005,Hoàng Văn P,23,Ninh Thuận
}
