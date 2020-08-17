package thuat_toan_tim_kiem.bai_tap;

import java.util.Arrays;

public class TimKiemNhiPhanSuDungDeQuy {
    public static int timKiem(int[] array, int viTriDau, int viTriCuoi, int number) {
        if (viTriCuoi >= viTriDau) {
            int viTriGiua = viTriDau + (viTriCuoi - viTriDau) / 2;
            if (array[viTriGiua] == number) return viTriGiua;
            else if (array[viTriGiua] > number) return timKiem(array, viTriDau, viTriGiua - 1, number);
            else return timKiem(array, viTriGiua + 1, viTriCuoi, number);
        } else return -1;
    }

    public static void main(String[] args) {
        int[] mang = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int soCanTim = 7;
        int ketQua = TimKiemNhiPhanSuDungDeQuy.timKiem(mang, 0, mang.length - 1, soCanTim);
        if (ketQua == -1) System.out.println("Số " + soCanTim + " không xuất hiện trong mảng " + Arrays.toString(mang));
        else System.out.println("Số " + soCanTim + " nằm ở vị trí " + ketQua + " trong mảng " + Arrays.toString(mang));
    }
}
