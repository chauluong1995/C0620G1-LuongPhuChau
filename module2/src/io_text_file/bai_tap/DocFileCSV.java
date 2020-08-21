package io_text_file.bai_tap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DocFileCSV {
    public static void main(String[] args) {

        String csvFile = "E:\\C0620G1\\module2\\src\\io_text_file\\bai_tap\\TenQuocGia.csv";
        //String txtFile = "E:\\C0620G1\\module2\\src\\io_text_file\\bai_tap\\demoFileTXT.txt";
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            //br = new BufferedReader(new FileReader(txtFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
                System.out.println("Country " + country[4] + " , name : " + country[5]);
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
