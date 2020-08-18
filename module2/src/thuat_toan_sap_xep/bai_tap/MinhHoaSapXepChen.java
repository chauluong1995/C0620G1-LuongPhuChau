package thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinhHoaSapXepChen {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập kích thước của mảng cần sắp xếp : ");
        int kichThuoc = scanner.nextInt();
        int[] mang = new int[kichThuoc];
        nhapDuLieu(mang,kichThuoc);

        // i = 1 để bắt đầu xét từ vị trí thứ 2 :
        for (int i = 1; i < kichThuoc; i++) {
            int phanTu = mang[i];
            int viTri = i;
            boolean kiemTraDoiCho = true;
            int dem = 1; // Biến này giúp câu " ..... thuật toán thực hiện : " chỉ in ra 1 lần :
            // Lặp tới khi trước phần tử mang[i] không còn phần tử nào lớn hơn nó :
            while (viTri > 0 && mang[viTri - 1] > phanTu) {
                kiemTraDoiCho = false;
                if (dem == 1) System.out.println("Vòng lặp thứ " + i + " thuật toán thực hiện : ");
                mang[viTri] = mang[viTri - 1];
                System.out.println("Đổi chỗ " + phanTu + " và " + mang[viTri - 1]);
                viTri--;
                dem--;

            }
            mang[viTri] = phanTu;
            if (!kiemTraDoiCho) {
                if (i < kichThuoc - 1) System.out.println("Mảng sau khi đổi chỗ các phần tử là : " + Arrays.toString(mang));
                else System.out.println("Mảng sau khi sắp xếp xong là : " + Arrays.toString(mang));
            } else System.out.println("Vòng lặp thứ " + i + " không có gì để sắp xếp !");
        }
    }

    public static void nhapDuLieu(int[] mang, int kichThuoc){
        for (int i = 0; i < kichThuoc; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " của mảng : ");
            mang[i] = scanner.nextInt();
        }
        System.out.println("Mảng ban đầu là : " + Arrays.toString(mang));
    }
}
