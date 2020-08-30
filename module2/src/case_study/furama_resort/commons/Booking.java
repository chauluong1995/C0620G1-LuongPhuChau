package case_study.furama_resort.commons;

import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;
import case_study.furama_resort.views.Show;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Booking {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean bookingVilla(Customer customer) throws IOException {
        List<Villa> list = Show.showAllVilla();
        if (!list.isEmpty()) {
            int soThuTu;
            do {
                System.out.print("Nhập số thứ tự của Villa bạn muốn chọn : ");
                String nhap = scanner.nextLine();
                if (Regex.kiemTraNhapSoNguyen(nhap)) {
                    soThuTu = Integer.parseInt(nhap);
                    if (soThuTu > 0 && soThuTu <= list.size()) break;
                }
                System.out.println("Lựa chọn của bạn không hợp lệ !");
            } while (true);

            customer.setDichVu(list.get(soThuTu - 1));
            return true;
            //list.clear();
        }
        return false;
    }

    public static boolean bookingHouse(Customer customer) throws IOException {
        List<House> list = Show.showAllHouse();
        if (!list.isEmpty()) {
            int soThuTu;
            do {
                System.out.print("Nhập số thứ tự của House bạn muốn chọn : ");
                String nhap = scanner.nextLine();
                if (Regex.kiemTraNhapSoNguyen(nhap)) {
                    soThuTu = Integer.parseInt(nhap);
                    if (soThuTu > 0 && soThuTu <= list.size()) break;
                }
                System.out.println("Lựa chọn của bạn không hợp lệ !");
            } while (true);

            customer.setDichVu(list.get(soThuTu - 1));
            return true;
            //list.clear();
        }
        return false;
    }

    public static boolean bookingRoom(Customer customer) throws IOException {
        List<Room> list = Show.showAllRoom();
        if (!list.isEmpty()) {
            int soThuTu;
            do {
                System.out.print("Nhập số thứ tự của Room bạn muốn chọn : ");
                String nhap = scanner.nextLine();
                if (Regex.kiemTraNhapSoNguyen(nhap)) {
                    soThuTu = Integer.parseInt(nhap);
                    if (soThuTu > 0 && soThuTu <= list.size()) break;
                }
                System.out.println("Lựa chọn của bạn không hợp lệ !");
            } while (true);

            customer.setDichVu(list.get(soThuTu - 1));
            return true;
            //list.clear();
        }
        return false;
    }
}
