package io_binary_file_serialization.thuc_hanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyFileDungLuongLon {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            assert is != null;
            is.close();
            assert os != null;
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter source file : "); // E:\C0620G1\module2\src\io_binary_file_serialization\thuc_hanh\fileNeedCopy.jpg
        String sourcePath = in.nextLine();
        System.out.print("Enter destination file : ");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            // Đọc và ghi tệp nhị phân bằng API I / O tệp mới (NIO) :
            copyFileUsingJava7Files(sourceFile, destFile);

            // Copy File dùng UsingStream :
            //copyFileUsingStream(sourceFile, destFile) :

            System.out.print("Copy completed !");
        } catch (IOException ioe) {
            System.out.print("Can't copy that file !");
            System.out.print(ioe.getMessage());
        }
    }
}
