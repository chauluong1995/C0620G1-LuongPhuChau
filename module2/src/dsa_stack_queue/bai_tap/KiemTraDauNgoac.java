package dsa_stack_queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraDauNgoac {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biểu thức cần kiểm tra : ");
        String string = scanner.nextLine();
        char temp;
        for (int i = 0; i < string.length(); i++) {
            temp = string.charAt(i);
            if (temp == '(') {
                stack.push(temp);
            }
            if (temp == ')') {
                if (stack.empty()) {
                    stack.push(temp);
                    break;
                } else stack.pop();
            }
        }
        boolean check = stack.empty();
        if (check) {
            System.out.println("Biểu thức " + string + " là hợp lệ !");
        } else System.out.println("Biểu thức " + string + "  không hợp lệ !");
    }
}
