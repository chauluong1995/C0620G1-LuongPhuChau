package io_binary_file_serialization.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu : \n1. Thêm sản phẩm\n2. Hiển thị danh sách sản phẩm\n3. Tìm kiếm sản phẩm\n4. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            int luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
            }
        }while (true);
    }
}
