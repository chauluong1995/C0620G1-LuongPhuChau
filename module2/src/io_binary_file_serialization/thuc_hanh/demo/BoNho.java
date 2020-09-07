package io_binary_file_serialization.thuc_hanh.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BoNho {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void luu(List<DoiTuong> list){
        File file = new File("src/io_binary_file_serialization/thuc_hanh/demo/luufile.csv");
        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        try {
            fileWriter = new FileWriter(file);
            bf = new BufferedWriter(fileWriter);
            bf.append("Số điện thoại,Nhóm của danh bạ,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            bf.append(XUONG_DONG);
            for (DoiTuong doiTuong : list){
                bf.append(doiTuong.toString());
                bf.append(XUONG_DONG);
            }
            bf.flush();
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bf != null) bf.close();
                    fileWriter.close();
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    public static List<DoiTuong> xuat(){
        List<DoiTuong> list = new ArrayList<>();
        File file = new File("src/io_binary_file_serialization/thuc_hanh/demo/luufile.csv");
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader br = null;
            try {
                fileReader = new FileReader(file);
                br = new BufferedReader(fileReader);
                DoiTuong doiTuong;
                String[] temp;
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    temp = line.split(DAU_PHAY);
                    doiTuong = new DoiTuong(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
                    list.add(doiTuong);
                }
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileReader != null) {
                        if (br != null) br.close();
                        fileReader.close();
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        }
        return list;
    }
}
