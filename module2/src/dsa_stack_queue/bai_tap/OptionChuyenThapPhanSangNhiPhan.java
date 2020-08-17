package dsa_stack_queue.bai_tap;

import java.util.Map;
import java.util.Stack;

public class OptionChuyenThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int soDangThapPhan = 27;
        int bienDem = 0;
        int bienTrungGian;
        int bienTam = soDangThapPhan;
        while (bienTam != 0) {
            bienTrungGian = bienTam % 2;
            stack.push(bienTrungGian);
            bienDem++;
            bienTam = bienTam / 2;
        }
        System.out.print("Số " + soDangThapPhan + " chuyển sang dạng nhị phân là : ");
        while (bienDem != 0) {
            System.out.print(stack.pop());
            bienDem--;
        }
        System.out.println();
        System.out.println(Integer.toBinaryString(soDangThapPhan));



        // Chuyển từ Nhị phân sang Thập phân :
        int soDangNhiPhan = 11011;
        int ketQuaThapPhan = 0;
        int bienDem_2 = 0;
        while (true) {
            if (soDangNhiPhan == 0) {
                break;
            } else {
                int bienTam_2 = soDangNhiPhan % 10;
                ketQuaThapPhan += bienTam_2 * Math.pow(2, bienDem_2);
                soDangNhiPhan = soDangNhiPhan / 10;
                bienDem_2++;
            }
        }
        System.out.println(ketQuaThapPhan);



        // Chuyển từ Thập phân sang Thập lục phân :
        String soDangThapLucPhan = Integer.toHexString(soDangThapPhan);
        System.out.println(soDangThapLucPhan);
    }
}
