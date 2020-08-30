package case_study.furama_resort.controllers;

import case_study.furama_resort.commons.Add;
import case_study.furama_resort.commons.Booking;
import case_study.furama_resort.commons.DocGhiFileCSV;
import case_study.furama_resort.commons.Regex;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.views.Show;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            //DocGhiFileCSV.lamMoiFile("Villa");
            displayMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMainMenu() throws IOException {
        int luaChon;
        do {
            System.out.println("Menu : \n1. Add New Services\n2. Show Services\n3. Add New Customer" +
                    "\n4. Show Information of Customer\n5. Add New Booking\n6. Show Information of Employee\n7. Exit");
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
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ !");
            }
        } while (true);
    }

    public static void addNewServices() throws IOException {
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


    public static void showServices() throws IOException {
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

    public static void addNewBooking() throws IOException {
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
                            }
                            break;
                        case 2:
                            if (Booking.bookingHouse(customer)) {
                                DocGhiFileCSV.ghiFileBooking(customer);
                            }
                            break;
                        case 3:
                            if (Booking.bookingRoom(customer)) {
                                DocGhiFileCSV.ghiFileBooking(customer);
                            }
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
}
