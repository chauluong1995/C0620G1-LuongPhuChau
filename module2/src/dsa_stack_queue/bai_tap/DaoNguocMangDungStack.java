package dsa_stack_queue.bai_tap;

import java.util.Stack;

public class DaoNguocMangDungStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arrays = new int[]{1996, 8, 10, 1995, 5, 27};
        for (int element : arrays) {
            stack.push(element);
        }
        System.out.print("Các phần tử của mảng sau khi đảo ngược là : ");
        for (int i = 0; i < arrays.length; i++){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        Stack<String> wStack = new Stack<>();
        String string = "nào như làm này Bài";
        String[] mWord = string.split("\\s");
        for (String word : mWord){
            wStack.push(word);
        }
        System.out.print("Chuỗi sau khi đảo ngược là : ");
        for (int i = 0; i < mWord.length; i++) {
            System.out.print(wStack.pop() + " ");
        }
    }
}
