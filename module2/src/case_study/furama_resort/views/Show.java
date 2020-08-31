package case_study.furama_resort.views;

import case_study.furama_resort.commons.DocGhiFileCSV;
import case_study.furama_resort.models.*;

import java.io.IOException;
import java.util.*;

public class Show {
    public static int bienDem = 0;

//    public static void showAllVilla() throws IOException {
//        List<Villa> list = DocGhiFileCSV.docFile("Villa");
//        for (Villa element : list) {
//            bienDem++;
//            System.out.println("Villa " + bienDem + element.showInfor());
//        }
//        bienDem = 0;
//    }

    public static List<Villa> showAllVilla() throws IOException {
        bienDem = 0;
        List<Villa> list = DocGhiFileCSV.docFileVilla();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có Villa nào !");
        else {
            System.out.println("Các Villa hiện tại có trong hệ thống là :");
            for (Villa element : list) {
                bienDem++;
                System.out.println(bienDem + " : Villa " + bienDem + element.showInfor());
            }
        }
        return list;
    }

    public static List<House> showAllHouse() throws IOException {
        bienDem = 0;
        List<House> list = DocGhiFileCSV.docFileHouse();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có House nào !");
        else {
            System.out.println("Các House hiện tại có trong hệ thống là :");
            for (House element : list) {
                bienDem++;
                System.out.println(bienDem + " : House " + bienDem + element.showInfor());
            }
        }
        return list;
    }

    public static List<Room> showAllRoom() throws IOException {
        bienDem = 0;
        List<Room> list = DocGhiFileCSV.docFileRoom();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có Room nào !");
        else {
            System.out.println("Các Room hiện tại có trong hệ thống là :");
            for (Room element : list) {
                bienDem++;
                System.out.println(bienDem + " : Room " + bienDem + element.showInfor());
            }
        }
        return list;
    }

    public static void showAllNameVillaNotDuplicate() throws IOException {
        List<Villa> list = DocGhiFileCSV.docFileVilla();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có Villa nào !");
        else {
            TreeSet<String> treeSet = new TreeSet<>();
//            TreeSet<String> treeSet = new TreeSet<>(new Comparator<>() {
//                @Override
//                public int compare(String s1, String s2) {
//                    return s2.compareTo(s1);
//                }
//            });
            System.out.println("Các Villa hiện tại có trong hệ thống là :");
            for (Villa villa : list) {
                treeSet.add(villa.getTenDichVu());
            }
            //System.out.println(treeSet);
            int bienDemVilla = 1;
            for (String ten : treeSet) {
                System.out.println(bienDemVilla + " : " + ten);
                bienDemVilla++;
            }
        }
    }

    public static void showAllNameHouseNotDuplicate() throws IOException {
        List<House> list = DocGhiFileCSV.docFileHouse();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có House nào !");
        else {
            TreeSet<String> treeSet = new TreeSet<>();
            System.out.println("Các House hiện tại có trong hệ thống là :");
            for (House house : list) {
                treeSet.add(house.getTenDichVu());
            }
            //System.out.println(treeSet);
            int bienDemHouse = 1;
            for (String ten : treeSet) {
                System.out.println(bienDemHouse + " : " + ten);
                bienDemHouse++;
            }
        }
    }

    public static void showAllNameRoomNotDuplicate() throws IOException {
        List<Room> list = DocGhiFileCSV.docFileRoom();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có Room nào !");
        else {
            TreeSet<String> treeSet = new TreeSet<>();
            System.out.println("Các Room hiện tại có trong hệ thống là :");
            for (Room room : list) {
                treeSet.add(room.getTenDichVu());
            }
            //System.out.println(treeSet);
            int bienDemRoom = 1;
            for (String ten : treeSet) {
                System.out.println(bienDemRoom + " : " + ten);
                bienDemRoom++;
            }
        }
    }

    public static List<Customer> showInformationCustomers() throws IOException {
        bienDem = 0;
        List<Customer> list = DocGhiFileCSV.docFileCustomer();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có Customer nào !");
        else {
            list.sort(new SapXepCustomer());
            System.out.println("Các Customer hiện tại có trong hệ thống là :");
            for (Customer element : list) {
                bienDem++;
                System.out.println(bienDem + " : Customer " + bienDem + element.showInfor());
            }
        }
        return list;
    }

    public static void showInformationOfEmployee() throws IOException {
        List<Employee> list = DocGhiFileCSV.docFileEmployee();
        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : list) {
            employeeMap.put(employee.getMaSoNhanVien(), employee);
        }
        System.out.println("Các Employee hiện tại có trong hệ thống là :");
        //System.out.println(employeeMap);
        for (Map.Entry<String, Employee> employeeEntry : employeeMap.entrySet()) {
            System.out.println(employeeEntry.toString());
        }
    }

    public static void findInformationEmployee() throws IOException {
        TuHoSo tuHoSo = new TuHoSo();
        Scanner scanner = new Scanner(System.in);
        boolean xacNhan = true;
        System.out.print("Nhập mã số nhân viên bạn muốn tìm hồ sơ : ");
        String maSo = scanner.nextLine();
        while (!tuHoSo.employeeStack.empty()) {
            Employee employee = tuHoSo.employeeStack.pop();
            if (maSo.equals(employee.getMaSoNhanVien())) {
                xacNhan = false;
                System.out.println("Hồ sơ nhân viên cần tìm là :" + employee);
                break;
            }
        }
        if (xacNhan) System.out.println("Nhân viên bạn tìm không có trong hệ thống !");
//        System.out.println("Các Employee hiện tại có trong hệ thống là :");
//        int bienDemEmployee = 1;
//        while (!tuHoSo.employeeStack.empty()){
//            System.out.println("Employee " + bienDemEmployee + tuHoSo.employeeStack.pop());
//            bienDemEmployee++;
//        }
    }
}
