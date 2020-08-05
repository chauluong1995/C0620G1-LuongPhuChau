package loops.bai_tap;

public class HienThiCacSoNguyenToNhoHonMotTram {
    public static void main(String[] args) {
        int soCanKiemTra = 2, i;
        boolean check;
        System.out.print("Các số nguyên tố nhỏ hơn 100 là : ");

        while (soCanKiemTra < 100) {
            check = true;
            i = 2;
            while (i <= Math.sqrt(soCanKiemTra)) {
                if (soCanKiemTra % i == 0) {
                    check = false;
                    break; // có thể đặt tên cho vòng lặp (label) rồi dùng break name; để thoát vòng lặp có tên đó !
                }
                i++;
            }
            if (check) {
                System.out.print(soCanKiemTra + " ");
            }
            soCanKiemTra++;
        }
    }
}
