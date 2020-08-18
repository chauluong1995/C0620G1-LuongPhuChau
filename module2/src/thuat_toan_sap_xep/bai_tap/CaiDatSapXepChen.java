package thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class CaiDatSapXepChen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước của mảng cần sắp xếp : ");
        int kichThuoc = scanner.nextInt();
        int[] mangBanDau = new int[kichThuoc];
        MinhHoaSapXepChen.nhapDuLieu(mangBanDau,kichThuoc);

        sapXepChen(mangBanDau,kichThuoc);
        System.out.println("Mảng sau khi sắp xếp xong là : " + Arrays.toString(mangBanDau));
    }

    public static void sapXepChen(int[] mang, int kichThuoc) {
        for (int i = 1; i < kichThuoc; i++) {
            int phanTu = mang[i];
            int viTri = i;
            // Lặp tới khi trước phần tử mang[i] không còn phần tử nào lớn hơn nó :
            while (viTri > 0 && mang[viTri - 1] > phanTu) {
                mang[viTri] = mang[viTri - 1];
                viTri--;
            }
            mang[viTri] = phanTu;
        }
    }
}
