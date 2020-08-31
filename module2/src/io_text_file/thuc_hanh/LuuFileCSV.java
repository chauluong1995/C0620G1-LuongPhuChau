package io_text_file.thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LuuFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void ghiFile(SanPham sanPham) throws IOException {
        File file = new File("src/io_text_file/thuc_hanh/products.csv");
        BufferedWriter bf = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bf = new BufferedWriter(fileWriter);

            StringBuilder stringBuilder = new StringBuilder();
            if (sanPham instanceof SanPhamNhapKhau){
                stringBuilder.append(sanPham.getId()).append(DAU_PHAY).append(sanPham.getMaSanPham()).append(DAU_PHAY)
                        .append(sanPham.getTenSanPham()).append(DAU_PHAY).append(sanPham.getGiaSanPham()).append(DAU_PHAY)
                        .append(sanPham.getSoLuongSanPham()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY)
                        .append(((SanPhamNhapKhau) sanPham).getGiaNhapKhau()).append(DAU_PHAY)
                        .append(((SanPhamNhapKhau) sanPham).getTinhThanhNhap()).append(DAU_PHAY)
                        .append(((SanPhamNhapKhau) sanPham).getThueNhapKhau());
            } else {
                stringBuilder.append(sanPham.getId()).append(DAU_PHAY).append(sanPham.getMaSanPham()).append(DAU_PHAY)
                        .append(sanPham.getTenSanPham()).append(DAU_PHAY).append(sanPham.getGiaSanPham()).append(DAU_PHAY)
                        .append(sanPham.getSoLuongSanPham()).append(DAU_PHAY).append(sanPham.getNhaSanXuat()).append(DAU_PHAY)
                        .append(((SanPhamXuatKhau) sanPham).getGiaXuatKhau()).append(DAU_PHAY)
                        .append(((SanPhamXuatKhau) sanPham).getQuocGiaNhapSanPham());
            }
            bf.write(stringBuilder.toString());
            bf.append(XUONG_DONG);
            bf.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert bf != null;
            bf.close();
        }
    }

    public static List<SanPham> docFile() throws IOException {
        List<SanPham> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            FileReader fileReader = new FileReader("src/case_study/furama_resort/data/products.csv");
            br = new BufferedReader(fileReader);
            SanPham sanPham;
            String[] temp;
            String line;
            while ((line = br.readLine()) != null) {
                temp = line.split(DAU_PHAY);
                if (temp.length == 9) sanPham = new SanPhamNhapKhau(temp[0], temp[1], temp[2], temp[3],temp[4], temp[5], temp[6], temp[7],temp[8]);
                else sanPham = new SanPhamXuatKhau(temp[0], temp[1], temp[2], temp[3],temp[4], temp[5], temp[6], temp[7]);
                list.add(sanPham);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            br.close();
        }
        return list;
    }
}
