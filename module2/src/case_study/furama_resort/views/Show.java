package case_study.furama_resort.views;

import case_study.furama_resort.commons.DocGhiFileCSV;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;

import java.io.IOException;
import java.util.List;

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
            for (Room element : list) {
                bienDem++;
                System.out.println(bienDem + " : Room " + bienDem + element.showInfor());
            }
        }
        return list;
    }

    public static void showAllNameVillaNotDuplicate() {

    }

    public static void showAllNameHouseNotDuplicate() {

    }

    public static void showAllNameRoomNotDuplicate() {

    }

    public static List<Customer> showInformationCustomers() throws IOException {
        bienDem = 0;
        List<Customer> list = DocGhiFileCSV.docFileCustomer();
        if (list.isEmpty()) System.out.println("Hiện tại chưa có Customer nào !");
        else {
            list.sort(new SapXepCustomer());
            for (Customer element : list) {
                bienDem++;
                System.out.println(bienDem + " : Customer " + bienDem + element.showInfo());
            }
        }
        return list;
    }
}
