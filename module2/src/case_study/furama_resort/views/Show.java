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

    public static void showAllVilla() throws IOException {
        List<Villa> list = DocGhiFileCSV.docFileVilla();
        for (Villa element : list) {
            bienDem++;
            System.out.println("Villa " + bienDem + element.showInfor());
        }
        bienDem = 0;
    }

    public static void showAllHouse() throws IOException {
        List<House> list = DocGhiFileCSV.docFileHouse();
        for (House element : list) {
            bienDem++;
            System.out.println("House " + bienDem + element.showInfor());
        }
        bienDem = 0;
    }

    public static void showAllRoom() throws IOException {
        List<Room> list = DocGhiFileCSV.docFileRoom();
        for (Room element : list) {
            bienDem++;
            System.out.println("Room " + bienDem + element.showInfor());
        }
        bienDem = 0;
    }

    public static void showAllNameVillaNotDuplicate() {

    }

    public static void showAllNameHouseNotDuplicate() {

    }

    public static void showAllNameRoomNotDuplicate() {

    }

    public static void showInformationCustomers() throws IOException {
        List<Customer> list = DocGhiFileCSV.docFileCustomer();
        for (Customer element : list) {
            bienDem++;
            System.out.println("Customer " + bienDem + element.showInfo());
        }
        bienDem = 0;
    }
}
