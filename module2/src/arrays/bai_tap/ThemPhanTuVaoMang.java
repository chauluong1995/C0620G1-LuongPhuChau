package arrays.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] mangSoNguyen = {11, 22, 33, 55, 66, 77, 88, 99, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần chèn vào mảng : ");
        int soCanChen = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn vào mảng : ");
        int viTriCanChen = scanner.nextInt();

        if (viTriCanChen < 0 ||  viTriCanChen > mangSoNguyen.length - 1){
            System.out.print("Rất tiếc vị trí cần chèn của bạn không hợp lệ !");
        }else {
            mangSoNguyen = insertElement(mangSoNguyen, soCanChen, viTriCanChen);
            System.out.print("Mảng số nguyên đã cho sau khi chèn số " + soCanChen + " là : ");
            for (int element : mangSoNguyen) {
                System.out.print(element + " ");
            }
        }

    }

    public static int[] insertElement(int[] mangBanDau, int soCanChen, int viTriCanChen) {
        int length = mangBanDau.length;
        int[] mangSauKhiChen = new int[length + 1];
        System.arraycopy(mangBanDau, 0, mangSauKhiChen, 0, viTriCanChen);
        mangSauKhiChen[viTriCanChen] = soCanChen;
        System.arraycopy(mangBanDau, viTriCanChen, mangSauKhiChen, viTriCanChen + 1, length - viTriCanChen);
        return mangSauKhiChen;
    }
}
