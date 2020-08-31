package io_text_file.thuc_hanh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LuuFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void ghiFile(List<String> thongTin) throws IOException {
        File file = new File("src/io_text_file/thuc_hanh/products.csv");
        BufferedWriter bf = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bf = new BufferedWriter(fileWriter);

            for (int i = 0; i < thongTin.size(); i++) {
                bf.append(thongTin.get(i));
                if (i == thongTin.size() - 1) break;
                bf.append(DAU_PHAY);
            }
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
}
