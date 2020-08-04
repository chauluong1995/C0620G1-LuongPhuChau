package introduction_to_java.bai_tap;
import java.util.Scanner;
public class UngDungDoiTien {
    public static void main(String[] args) {
        int tiGia = 23000;
        Scanner scanner = new Scanner(System.in);
        float dollar,vietNamDong;
        System.out.print("Nhập giá trị USD cần chuyển đổi : ");
        dollar = scanner.nextFloat();
        vietNamDong = dollar * tiGia;
        System.out.println(dollar + " USD bằng " + vietNamDong + " VND.");
    }
}
