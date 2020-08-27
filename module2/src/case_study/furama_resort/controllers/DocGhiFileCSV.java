package case_study.furama_resort.controllers;

import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Services;
import case_study.furama_resort.models.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static String path = "";

    public static void kiemTraDichVu(String tenFile) {
        if (tenFile.equals("Villa")) path = "src/case_study/furama_resort/data/Villa.csv";
        //ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , tiêu chuẩn phòng , mô tả tiện nghi khác , diện tích hồ bơi , số tầng
        if (tenFile.equals("House")) path = "src/case_study/furama_resort/data/House.csv";
        //ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , tiêu chuẩn phòng , mô tả tiện nghi khác , số tầng
        if (tenFile.equals("Room")) path = "src/case_study/furama_resort/data/Room.csv";
        //ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , dịch vụ miễn phí đi kèm
    }

    public static void ghiFile(String tenFile, List<String> thongTin) throws IOException {
        kiemTraDichVu(tenFile);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path, true);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (int i = 0; i < thongTin.size(); i++) {
                fileWriter.append(thongTin.get(i));
                if (i == thongTin.size() - 1) break;
                fileWriter.append(COMMA_DELIMITER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert fileWriter != null;
            fileWriter.close();
        }
    }

    public static List docFile(String tenFile) throws IOException {
        List list = new ArrayList();
        kiemTraDichVu(tenFile);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            Services services = null;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(",");
                if (tenFile.equals("Villa")) services = new Villa(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],temp[8],temp[9]);
                if (tenFile.equals("House")) services = new House(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],temp[8]);
                if (tenFile.equals("Room")) services = new Room(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                list.add(services);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return list;
    }
}
