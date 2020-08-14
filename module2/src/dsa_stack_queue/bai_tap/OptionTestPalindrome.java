package dsa_stack_queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;

public class OptionTestPalindrome {
    public static void main(String[] args) {
        String string = "Able was I ere I saw elbA";
        Queue<Character> queue = new LinkedList<>();
        for (int i = string.length() - 1; i >= 0; i--) {
            queue.add(string.charAt(i));
        }
        StringBuilder reverseString = new StringBuilder();
        while (!queue.isEmpty()) {
            reverseString.append(queue.remove());
        }
        if (string.equals(reverseString.toString())) {
            System.out.println("Chuỗi ' " + string + " ' là 1 chuỗi Palindrome !");
        } else System.out.println("Chuỗi ' " + string + " ' không phải chuỗi Palindrome !");
    }
}
