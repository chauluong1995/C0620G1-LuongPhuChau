package dsa_stack_queue.bai_tap;

import java.util.Stack;

public class OptionChuyenThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int soDangThapPhan = 27;
        int count = 0;
        int result;
        int temp = soDangThapPhan;
        while (temp != 0) {
            result = temp % 2;
            stack.push(result);
            count++;
            temp = temp / 2;
        }
        System.out.print("Số " + soDangThapPhan + " chuyển sang dạng nhị phân là : ");
        while (count != 0) {
            System.out.print(stack.pop());
            count--;
        }
    }
}
