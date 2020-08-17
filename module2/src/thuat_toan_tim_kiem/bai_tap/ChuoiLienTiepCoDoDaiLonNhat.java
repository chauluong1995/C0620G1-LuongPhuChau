package thuat_toan_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiLienTiepCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Enter a string: ");
        String string = input.nextLine();


        for (int i = 0; i < string.length(); i++) {
            // Trong chuỗi nhập có kí tự nhỏ hơn kí tự cuối trong list và list có chứa kí tự đó thì clear list :
            if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
                list.clear();
            }

            // Thêm kí tự vào list :
            list.add(string.charAt(i));

            // Size của list lớn hơn max thì thay max = list :
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }

        for (Character element : max) {
            System.out.print(element);
        }
        System.out.println();
    }
}
