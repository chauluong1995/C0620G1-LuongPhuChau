package case_study.furama_resort.commons;

import case_study.furama_resort.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";
    public static String path = "";

    public static void lamMoiFile(String tenFile) {
        kiemTraDichVu(tenFile);

        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        try {
            fileWriter = new FileWriter(path);
            bf = new BufferedWriter(fileWriter);
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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bf != null) bf.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void kiemTraDichVu(String tenFile) {
        if (tenFile.equals("Villa")) path = "src/case_study/furama_resort/data/Villa.csv";
        if (tenFile.equals("House")) path = "src/case_study/furama_resort/data/House.csv";
        if (tenFile.equals("Room")) path = "src/case_study/furama_resort/data/Room.csv";
        if (tenFile.equals("Customer")) path = "src/case_study/furama_resort/data/Customer.csv";
    }

    public static void ghiFile(String tenFile, List<String> thongTin) {
        kiemTraDichVu(tenFile);

        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        try {
            fileWriter = new FileWriter(path, true);
            bf = new BufferedWriter(fileWriter);

            bf.append(XUONG_DONG);
            for (int i = 0; i < thongTin.size(); i++) {
                bf.append(thongTin.get(i));
                if (i == thongTin.size() - 1) break;
                bf.append(DAU_PHAY);
            }
            bf.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bf != null) bf.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ghiFileBooking(Customer customer) {
        File file = new File("src/case_study/furama_resort/data/Booking.csv");
        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        try {
            fileWriter = new FileWriter(file, true);
            bf = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(customer.getHoTen()).append(DAU_PHAY).append(customer.getNgaySinh()).append(DAU_PHAY)
                    .append(customer.getGioiTinh()).append(DAU_PHAY).append(customer.getCmnd()).append(DAU_PHAY).append(customer.getSoDienThoai())
                    .append(DAU_PHAY).append(customer.getEmail()).append(DAU_PHAY).append(customer.getLoaiKhach()).append(DAU_PHAY)
                    .append(customer.getDiaChi()).append(DAU_PHAY).append("Dịch vụ").append(customer.getDichVu());
            bf.write(stringBuilder.toString());
            bf.append("\n");
            bf.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bf != null) bf.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Villa> docFileVilla() {
        List<Villa> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader("src/case_study/furama_resort/data/Villa.csv");
            br = new BufferedReader(fileReader);
            Villa villa;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                villa = new Villa(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                list.add(villa);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    if (br != null) br.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<House> docFileHouse() {
        List<House> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader("src/case_study/furama_resort/data/House.csv");
            br = new BufferedReader(fileReader);
            House house;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                house = new House(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                list.add(house);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    if (br != null) br.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<Room> docFileRoom() {
        List<Room> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader("src/case_study/furama_resort/data/Room.csv");
            br = new BufferedReader(fileReader);
            Room room;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                room = new Room(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
                list.add(room);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    if (br != null) br.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<Customer> docFileCustomer() {
        List<Customer> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader("src/case_study/furama_resort/data/Customer.csv");
            br = new BufferedReader(fileReader);
            Customer customer;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                customer = new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
                list.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    if (br != null) br.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<Employee> docFileEmployee() {
        List<Employee> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader("src/case_study/furama_resort/data/Employee.csv");
            br = new BufferedReader(fileReader);
            Employee employee;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                employee = new Employee(temp[0], temp[1], temp[2], temp[3]);
                list.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    if (br != null) br.close();
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

//    public static List docFile(String tenFile) {
//        List list = new ArrayList();
//        kiemTraDichVu(tenFile);
//
//        FileReader fileReader = null;
//        BufferedReader br = null;
//        try {
//            fileReader = new FileReader(path);
//            br = new BufferedReader(fileReader);
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
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileReader != null) {
//                    if (br != null) br.close();
//                    fileReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
}
