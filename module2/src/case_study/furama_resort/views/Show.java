package case_study.furama_resort.views;

import case_study.furama_resort.commons.DocGhiFileCSV;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;

import java.io.IOException;
import java.util.List;

public class Show {
    public static int bienDem = 0;

    public static void showAllVilla() throws IOException {
        List<Villa> list = DocGhiFileCSV.docFile("Villa");
        for (Villa element : list) {
            bienDem++;
            System.out.print("Villa " + bienDem);
            element.showInfor();
        }
        bienDem = 0;
    }

    public static void showAllHouse() throws IOException {
        List<House> list = DocGhiFileCSV.docFile("House");
        for (House element : list) {
            bienDem++;
            System.out.print("House " + bienDem);
            element.showInfor();
        }
        bienDem = 0;
    }

    public static void showAllRoom() throws IOException {
        List<Room> list = DocGhiFileCSV.docFile("Room");
        for (Room element : list) {
            bienDem++;
            System.out.print("Room " + bienDem);
            element.showInfor();
        }
        bienDem = 0;
    }

    public static void showAllNameVillaNotDuplicate() {

    }

    public static void showAllNameHouseNotDuplicate() {

    }

    public static void showAllNameRoomNotDuplicate() {

    }

    public static void showInformationCustomers() {

    }
}
