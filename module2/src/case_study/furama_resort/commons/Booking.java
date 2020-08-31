package case_study.furama_resort.commons;

import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;
import case_study.furama_resort.views.Show;

import java.io.IOException;
import java.util.*;

public class Booking {
    public static Scanner scanner = new Scanner(System.in);
    public static Queue<Customer> queue = new LinkedList<>();
    //public static List<Customer> listBuyMovieTickets = new ArrayList<>();
    public static int bienDemVe = 0;

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

    public static void buyMovieTickets() throws IOException {
        if (bienDemVe < 5) {
            List<Customer> list = Show.showInformationCustomers();
            if (!list.isEmpty()) {
                int soThuTu;
                do {
                    System.out.print("Chọn số thứ tự Customer muốn đặt vé xem phim : ");
                    String nhap = scanner.nextLine();
                    if (Regex.kiemTraNhapSoNguyen(nhap)) {
                        soThuTu = Integer.parseInt(nhap);
                        if (soThuTu > 0 && soThuTu <= list.size()) break;
                    }
                    System.out.println("Lựa chọn của bạn không hợp lệ !");
                } while (true);

                Customer customer = list.get(soThuTu - 1);
                queue.add(customer);
                bienDemVe++;
                System.out.println("Đặt vé xem phim thành công !");
            }
        }
        if (bienDemVe == 5) {
            System.out.println("Vé xem phim đã được bán hết ! Danh sách các Customer đã mua vé là :");
            int bienDemCustomer = 1;
            while (!queue.isEmpty()) {
                System.out.println("Customer " + bienDemCustomer + queue.remove().showInfor());
                bienDemCustomer++;
            }
            bienDemVe = 0;
        }
    }

//    public static void buyMovieTickets() throws IOException {
//        if (bienDemVe < 5) {
//            List<Customer> list = Show.showInformationCustomers();
//            if (!list.isEmpty()) {
//                int soThuTu;
//                do {
//                    System.out.print("Chọn số thứ tự Customer muốn đặt vé xem phim : ");
//                    String nhap = scanner.nextLine();
//                    if (Regex.kiemTraNhapSoNguyen(nhap)) {
//                        soThuTu = Integer.parseInt(nhap);
//                        if (soThuTu > 0 && soThuTu <= list.size()) break;
//                    }
//                    System.out.println("Lựa chọn của bạn không hợp lệ !");
//                } while (true);
//
//                Customer customer = list.get(soThuTu - 1);
//                listBuyMovieTickets.add(customer);
//                bienDemVe++;
//                System.out.println("Đặt vé xem phim thành công !");
//            }
//        }
//        if (bienDemVe == 5) {
//            Queue<Customer> bienTam = new LinkedList<>(listBuyMovieTickets);
//            System.out.println("Vé xem phim đã được bán hết ! Danh sách các Customer đã mua vé là :");
//            int bienDemCustomer = 1;
//            while (!bienTam.isEmpty()) {
//                System.out.println("Customer " + bienDemCustomer + bienTam.remove().showInfor());
//                bienDemCustomer++;
//            }
//            do {
//                System.out.print("Bạn có muốn làm mới danh sách vé không ? Nếu muốn làm mới thì nhập mật khẩu ! Nếu không thì nhập Thoát : ");
//                String nhap = scanner.nextLine();
//                if (nhap.equals("Admin")) {
//                    listBuyMovieTickets.clear();
//                    bienDemVe = 0;
//                    System.out.println("Làm mới thành công !");
//                    break;
//                }
//                if (nhap.equals("Thoát")) break;
//                System.out.println("Sai mật khẩu !");
//            } while (true);
//        }
//    }
}
