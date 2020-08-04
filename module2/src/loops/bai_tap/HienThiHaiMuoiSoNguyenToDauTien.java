package loops.bai_tap;

import java.util.Scanner;

public class HienThiHaiMuoiSoNguyenToDauTien {
    public static void main(String[] args) {
        int soLuongCanIn,bienDem=0,soCanKiemTra=2,i;
        boolean check;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập số lượng số nguyên tố cần in : ");
            soLuongCanIn = scanner.nextInt();
            if (soLuongCanIn<=0){
                System.out.println("Số lượng bạn nhập không hợp lí !");
            }else break;
        }while (true);
        while (bienDem<soLuongCanIn){
            check = true;
            i = 2;
            while (i <= Math.sqrt(soCanKiemTra)) {
                if (soCanKiemTra % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (bienDem == (soLuongCanIn - 1)){
                if (check){
                    System.out.print(soCanKiemTra);
                    break;
                }
            }
            else if (check){
                System.out.print(soCanKiemTra + " , ");
                bienDem++;
            }
            soCanKiemTra++;
        }
    }
}
