package io_text_file.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void copyFile(String pathFileNeedCopy, String pathFileReceive) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        Scanner scanner = new Scanner(System.in);
        boolean kiemTraGhiDe = true;
        int luaChon = 0;

        File fileNeedCopy = new File(pathFileNeedCopy);
        File fileReceive = new File(pathFileReceive);

        if (fileReceive.exists()) {
            System.out.println("File này đã tồn tại ! Bạn có muốn ghi đè hay không ?" +
                    "\nNhập 1 nếu không muốn ghi đè , nhập bất cứ gì khác 1 thì việc ghi đè sẽ diễn ra !");
            System.out.println("Nhập lựa chọn của bạn : ");
            luaChon = scanner.nextInt();
        }

        if (luaChon == 1) kiemTraGhiDe = false; // Bỏ lệnh Copy !
        if (kiemTraGhiDe) {
            try {
                if (!fileNeedCopy.exists()) throw new FileNotFoundException();

                inputStream = new FileInputStream(fileNeedCopy);
                outputStream = new FileOutputStream(fileReceive);
                int length;
                byte[] buffer = new byte[1024];
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                System.out.println("Copy thành công !");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file gốc ( file cần copy ) : "); // E:\C0620G1\module2\src\io_text_file\bai_tap\TenQuocGia.csv
        String pathFileNeedCopy = scanner.nextLine();
        System.out.println("Nhập đường dẫn file nhận nội dung copy : ");
        String pathFileReceive = scanner.nextLine();
        copyFile(pathFileNeedCopy, pathFileReceive);
        System.out.println("Kết thúc chương trình !");
    }
}
