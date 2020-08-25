package case_study.furama_resort.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DocGhiFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static String path = "";
    public static String tieuDe = "";

    public static void kiemTraDichVu(String tenFile) {
        if (tenFile.equals("Villa")) {
            path = "E:\\C0620G1\\module2\\src\\case_study\\furama_resort\\data\\Villa.csv";
            tieuDe = "ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , " +
                    "tiêu chuẩn phòng , mô tả tiện nghi khác , diện tích hồ bơi , số tầng";
        }
        if (tenFile.equals("House")) {
            path = "E:\\C0620G1\\module2\\src\\case_study\\furama_resort\\data\\House.csv";
            tieuDe = "ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , " +
                    "tiêu chuẩn phòng , mô tả tiện nghi khác , số tầng";
        }
        if (tenFile.equals("Room")) {
            path = "E:\\C0620G1\\module2\\src\\case_study\\furama_resort\\data\\Room.csv";
            tieuDe = "ID , tên dịch vụ , diện tích sử dụng , chi phí thuê , số lượng người tối đa , kiểu thuê , " +
                    "dịch vụ miễn phí đi kèm";
        }
    }

    public static void ghiFile(String tenFile, List<String> thongTin) {
        kiemTraDichVu(tenFile);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(path, true);
            fileWriter.append(tieuDe);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (int i = 0; i < thongTin.size(); i++) {
                fileWriter.append(thongTin.get(i));
                if (i == thongTin.size() - 1) break;
                fileWriter.append(COMMA_DELIMITER);
            }
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void docFile(String tenFile) {
        kiemTraDichVu(tenFile);
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
