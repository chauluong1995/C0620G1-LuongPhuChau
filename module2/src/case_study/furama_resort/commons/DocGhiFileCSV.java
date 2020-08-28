package case_study.furama_resort.commons;

import case_study.furama_resort.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";
    public static String path = "";

    public static void kiemTraDichVu(String tenFile) {
        if (tenFile.equals("Villa")) path = "src/case_study/furama_resort/data/Villa.csv";
        if (tenFile.equals("House")) path = "src/case_study/furama_resort/data/House.csv";
        if (tenFile.equals("Room")) path = "src/case_study/furama_resort/data/Room.csv";
        if (tenFile.equals("Customer")) path = "src/case_study/furama_resort/data/Customer.csv";
    }

    public static void ghiFile(String tenFile, List<String> thongTin) throws IOException {
        kiemTraDichVu(tenFile);
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bf = new BufferedWriter(fileWriter);
        try {
            bf.append(XUONG_DONG);
            for (int i = 0; i < thongTin.size(); i++) {
                bf.append(thongTin.get(i));
                if (i == thongTin.size() - 1) break;
                bf.append(DAU_PHAY);
            }
            bf.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bf.close();
            fileWriter.close();
        }
    }

    public static void lamMoiFile(String tenFile) throws IOException {
        kiemTraDichVu(tenFile);
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fileWriter);
        try {
            if (tenFile.equals("Villa")) {
                bf.append("ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , " +
                        "kiểu thuê , tiêu chuẩn phòng , mô tả tiện nghi khác , diện tích hồ bơi , số tầng");
            }
            if (tenFile.equals("House")) {
                bf.append("ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , " +
                        "kiểu thuê , tiêu chuẩn phòng , mô tả tiện nghi khác , số tầng");
            }
            if (tenFile.equals("Room")) {
                bf.append("ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , dịch vụ miễn phí đi kèm");
            }
            if (tenFile.equals("Customer")) {
                bf.append("Họ tên, ngày sinh, giới tính, số CMND, số điện thoại, email, loại khách, địa chỉ, dịch vụ");
            }
            bf.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bf.close();
            fileWriter.close();
        }
    }

    public static List<Villa> docFileVilla() throws IOException {
        List<Villa> list = new ArrayList<>();
        FileReader fileReader = new FileReader("src/case_study/furama_resort/data/Villa.csv");
        BufferedReader br = new BufferedReader(fileReader);
        try {
            Villa villa;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                villa = new Villa(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                list.add(villa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return list;
    }

    public static List<House> docFileHouse() throws IOException {
        List<House> list = new ArrayList<>();
        FileReader fileReader = new FileReader("src/case_study/furama_resort/data/House.csv");
        try (BufferedReader br = new BufferedReader(fileReader)) {
            House house;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                house = new House(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                list.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Room> docFileRoom() throws IOException {
        List<Room> list = new ArrayList<>();
        FileReader fileReader = new FileReader("src/case_study/furama_resort/data/Room.csv");
        try (BufferedReader br = new BufferedReader(fileReader)) {
            Room room;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                room = new Room(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
                list.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Customer> docFileCustomer() throws IOException {
        List<Customer> list = new ArrayList<>();
        FileReader fileReader = new FileReader("src/case_study/furama_resort/data/Customer.csv");
        try (BufferedReader br = new BufferedReader(fileReader)) {
            Customer customer;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                customer = new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
                list.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

//        public static List docFile(String tenFile) throws IOException {
//        List list = new ArrayList();
//        kiemTraDichVu(tenFile);
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        try {
//            Services services = null;
//            Customer customer;
//            String[] temp;
//            String line = br.readLine();
//            while ((line = br.readLine()) != null) {
//                temp = line.split(DAU_PHAY);
//                if (tenFile.equals("Customer")){
//                    customer = new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
//                    list.add(customer);
//                } else {
//                    if (tenFile.equals("Villa"))
//                        services = new Villa(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
//                    if (tenFile.equals("House"))
//                        services = new House(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
//                    if (tenFile.equals("Room"))
//                        services = new Room(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
//                    list.add(services);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            br.close();
//        }
//        return list;
//    }
}
