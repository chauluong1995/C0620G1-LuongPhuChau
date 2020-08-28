package case_study.furama_resort.commons;

import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Services;
import case_study.furama_resort.models.Villa;

import java.io.*;
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
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bf = new BufferedWriter(fileWriter);
        try {
            bf.append(NEW_LINE_SEPARATOR);
            for (int i = 0; i < thongTin.size(); i++) {
                bf.append(thongTin.get(i));
                if (i == thongTin.size() - 1) break;
                bf.append(COMMA_DELIMITER);
            }
            bf.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bf.close();
            fileWriter.close();
        }
    }

    public static List docFile(String tenFile) throws IOException {
        List list = new ArrayList();
        kiemTraDichVu(tenFile);
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            Services services = null;
            String[] temp;
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                temp = line.split(",");
                if (tenFile.equals("Villa"))
                    services = new Villa(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                if (tenFile.equals("House"))
                    services = new House(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                if (tenFile.equals("Room"))
                    services = new Room(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
                list.add(services);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return list;
    }
}
