package bai_thi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void ghiVaoFile(List<DanhBa> boNho) {
        File file = new File("E:\\C0620G1\\module2\\src\\bai_thi\\danh_ba.csv");
        FileWriter ghiFile = null;
        BufferedWriter boNhoDem = null;
        try {
            ghiFile = new FileWriter(file);
            boNhoDem = new BufferedWriter(ghiFile); // Không phải ghi đè như mình nghĩ !!!!!
            boNhoDem.append("Số điện thoại,Nhóm của danh bạ,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            boNhoDem.append(XUONG_DONG);
            for (DanhBa phanTu : boNho) {
                boNhoDem.append(phanTu.toString());
                boNhoDem.append(XUONG_DONG);
            }
            boNhoDem.flush();
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ghiFile != null) {
                    if (boNhoDem != null) boNhoDem.close();
                    ghiFile.close();
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    public static List<DanhBa> xuatTuFile() {
        List<DanhBa> boNho = new ArrayList<>();
        File file = new File("E:\\C0620G1\\module2\\src\\bai_thi\\danh_ba.csv");
        if (file.isFile()) {
            FileReader docFile = null;
            BufferedReader boNhoDem = null;
            try {
                docFile = new FileReader(file);
                boNhoDem = new BufferedReader(docFile);
                DanhBa danhBa;
                String[] mangTam;
                String dong = boNhoDem.readLine();
                while ((dong = boNhoDem.readLine()) != null) {
                    mangTam = dong.split(DAU_PHAY);
                    danhBa = new DanhBa(mangTam[0], mangTam[1], mangTam[2], mangTam[3], mangTam[4], mangTam[5], mangTam[6]);
                    boNho.add(danhBa);
                }
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (docFile != null) {
                        if (boNhoDem != null) boNhoDem.close();
                        docFile.close();
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        }
        return boNho;
    }
}
