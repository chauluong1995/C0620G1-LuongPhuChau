package io_text_file.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LuuFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void ghiFile(SanPham sanPham, String cachGhi) {
        File file = new File("src/io_text_file/thuc_hanh/products.csv");
        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        try {
            if (cachGhi.equals("ghi đè")) fileWriter = new FileWriter(file);
            if (cachGhi.equals("thêm")) fileWriter = new FileWriter(file, true);
            if (fileWriter != null) {
                bf = new BufferedWriter(fileWriter);
                StringBuilder stringBuilder = new StringBuilder();
                if (sanPham instanceof Nhap) {
                    stringBuilder.append(sanPham.getId()).append(DAU_PHAY).append(sanPham.getMaSanPham()).append(DAU_PHAY)
                            .append(sanPham.getTenSanPham()).append(DAU_PHAY).append(sanPham.getGiaSanPham()).append(DAU_PHAY)
                            .append(sanPham.getSoLuongSanPham()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY)
                            .append(((Nhap) sanPham).getGiaNhapKhau()).append(DAU_PHAY)
                            .append(((Nhap) sanPham).getTinhThanhNhap()).append(DAU_PHAY)
                            .append(((Nhap) sanPham).getThueNhapKhau());
                } else {
                    stringBuilder.append(sanPham.getId()).append(DAU_PHAY).append(sanPham.getMaSanPham()).append(DAU_PHAY)
                            .append(sanPham.getTenSanPham()).append(DAU_PHAY).append(sanPham.getGiaSanPham()).append(DAU_PHAY)
                            .append(sanPham.getSoLuongSanPham()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY)
                            .append(((Xuat) sanPham).getGiaXuatKhau()).append(DAU_PHAY)
                            .append(((Xuat) sanPham).getQuocGiaNhapSanPham());
                }
                bf.write(stringBuilder.toString());
                bf.append(XUONG_DONG);
                bf.flush();
            }
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

    public static void capNhatFile(List<SanPham> list) {
//        File file = new File("src/io_text_file/thuc_hanh/products.csv");
//        if (file.delete())
//            System.out.println("Cập nhật file sản phẩm !");
//        try {
//            if (file.createNewFile()) System.out.println("Cập nhật thành công !");
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
        int xacNhan = 1;
        if (list.isEmpty()) {
            File file = new File("src/io_text_file/thuc_hanh/products.csv");
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.append("");
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        } else {
            for (SanPham sanPham : list) {
                if (xacNhan == 1) ghiFile(sanPham, "ghi đè");
                else ghiFile(sanPham, "thêm");
                xacNhan++;
            }
        }
    }

    public static List<SanPham> docFile() {
        List<SanPham> list = new ArrayList<>();
        File file = new File("src/io_text_file/thuc_hanh/products.csv");
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader br = null;
            try {
                fileReader = new FileReader(file);
                br = new BufferedReader(fileReader);
                SanPham sanPham;
                String[] temp;
                String line;
                while ((line = br.readLine()) != null) {
                    temp = line.split(DAU_PHAY);
                    if (temp.length == 9) {
                        sanPham = new Nhap(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
                                temp[8]);
                        list.add(sanPham);
                    }
                    if (temp.length == 8) {
                        sanPham = new Xuat(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
                        list.add(sanPham);
                    }
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
        } else {
            try {
                if (file.createNewFile()) System.out.println("File đang trống !");
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        return list;
    }
}
