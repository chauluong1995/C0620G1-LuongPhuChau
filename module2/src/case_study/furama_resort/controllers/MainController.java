package case_study.furama_resort.controllers;

import java_collection_framework.bai_tap.quan_li_san_pham.QuanLySanPham;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("Menu : \n1. Add New Services\n2. Show Services\n3. Add New Customer" +
                    "\n4. Show Information of Customer\n5. Add New Booking\n6. Show Information of Employee\n7. Exit");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (QuanLySanPham.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                if (luaChon >= 1 && luaChon <= 7) {
                    switch (luaChon) {
                        case 1:

                            scanner.nextLine();
                            break;
//                        case 2:
//                            scanner.nextLine();
//                            break;
//                        case 3:
//                            scanner.nextLine();
//                            break;
//                        case 4:
//                            scanner.nextLine();
//                            break;
//                        case 5:
//                            scanner.nextLine();
//                            break;
//                        case 6:
//                            scanner.nextLine();
//                            break;
                        case 7:
                            System.exit(0);
                            //return;
                    }
                } else {
                    System.out.print("Lựa chọn không tồn tại !");
                    scanner.nextLine();
                }
            } else {
                System.out.print("Lựa chọn không hợp lệ !");
                scanner.nextLine();
            }
        } while (true);
    }


}
