package thuat_toan_tim_kiem.thuc_hanh;

import java.util.Scanner;

public class TinhDoPhucTap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi bất kỳ : ");
        String chuoi = scanner.nextLine();

        int[] bangKiTu = new int[255];                                      // Lênh 1 thời gian O(1)
        for (int i = 0; i < chuoi.length(); i++) {                          // Lệnh 2 thời gian O(n * 1) = O(n) với n là length
            /* Tìm ví trí tương ứng của ký tự trong bảng kí tự ASCII */
            int ascii = chuoi.charAt(i);                                    // Lệnh 3 thời gian O(1)
            /* Tăng giá trị tần suất */
            bangKiTu[ascii] += 1;                                           // Lệnh 4 thời gian O(1)
        }

        int max = 0;                                                        // Lệnh 5 thời gian O(1)
        char kiTu = (char) 255;                                             // Lệnh 6 thời gian O(255 * 1) = O(255)
        for (int j = 0; j < 255; j++) {                                     // Lệnh 7 thời gian O(1)
            if (bangKiTu[j] > max) {                                        // Lệnh 8 thời gian O(1)
                max = bangKiTu[j];                                          // Lệnh 9 thời gian O(1)
                kiTu = (char) j;                                            // Lệnh 10 thời gian O(1)
            }
        }
        System.out.println("Kí tự xuất hiện nhiều nhất là " + kiTu + " , số lần xuất hiện là " + max);
    }
}
    // Tính độ phức tạp của thuật toán :
    // Độ phức tạp của thuật toán ( hiện tại xét theo thời gian ) là :
    // Thời gian thực hiện chuỗi lệnh {1}, {2}, {5}, {6}, {7} và được tính bằng thời gian thi hành lệnh lâu nhất trong chuỗi lệnh .
    // Nếu n <= 255 thì khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh 7 và bằng O(255) .
    // Nếu n > 255 thì khi đó độ phức tạp của thuật toán  sẽ là thời gian thực hiện lệnh 2 và bằng O(n) .