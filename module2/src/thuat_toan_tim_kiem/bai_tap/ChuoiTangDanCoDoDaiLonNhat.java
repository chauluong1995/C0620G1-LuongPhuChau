package thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiTangDanCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        // Tạo biến lưu chuỗi dài nhất :
        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();

            // Thêm kí tự đầu tiên :
            list.add(string.charAt(i));

            // Duyệt từ kí tự tiếp theo :
            for (int j = i + 1; j < string.length(); j++) {
                // chỉ lấy kí tự lớn hơn :
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            // Chuỗi vừa tạo mà lớn hơn thì thay max bằng chuỗi vừa tạo :
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }

            // Xóa chuỗi vừa tạo để duyệt tiếp :
            list.clear();
        }

        for (Character element : max) {
            System.out.print(element);
        }
    }
}
