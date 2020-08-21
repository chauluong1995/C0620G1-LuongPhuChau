package io_text_file.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {

    public static void copyFile(String pathFileNeedCopy, String pathFileReceive) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean kiemTraGhiDe = true;
        String luaChon = "";
        int soLuongKiTu = 0;

        File fileNeedCopy = new File(pathFileNeedCopy);
        File fileReceive = new File(pathFileReceive);

        if (fileReceive.exists()) {
            System.out.println("File này đã tồn tại ! Bạn có muốn ghi đè hay không ?" +
                    "\nNhập 1 nếu không muốn ghi đè , nhập bất cứ gì khác 1 thì việc ghi đè sẽ diễn ra !");
            System.out.println("Nhập lựa chọn của bạn : ");
            luaChon = scanner.nextLine();
        }

        if (luaChon.equals("1")) kiemTraGhiDe = false; // Bỏ lệnh Copy !
        if (kiemTraGhiDe) {
            try {
                if (!fileNeedCopy.exists()) throw new FileNotFoundException();

                InputStream inputStream = new FileInputStream(fileNeedCopy);
                OutputStream outputStream = new FileOutputStream(fileReceive);
                int length;
                byte[] buffer = new byte[1024];
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                    //System.out.println(length);
                    soLuongKiTu += length;
                }
                System.out.println("Copy thành công !");
                System.out.println("Số kí tự trong tệp tin đích là : " + soLuongKiTu);
            } catch (FileNotFoundException e) {
                System.err.println("Fie không tồn tại or nội dung có lỗi!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn tệp nguồn : "); // E:\C0620G1\module2\src\io_text_file\bai_tap\demoFileTXT.txt
        String pathFileNeedCopy = scanner.nextLine();
        System.out.println("Nhập đường dẫn tệp tin đích : ");
        String pathFileReceive = scanner.nextLine();
        copyFile(pathFileNeedCopy, pathFileReceive);
        System.out.println("Kết thúc chương trình !");
    }
}
