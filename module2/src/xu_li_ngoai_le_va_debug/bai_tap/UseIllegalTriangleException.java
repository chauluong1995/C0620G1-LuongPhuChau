package xu_li_ngoai_le_va_debug.bai_tap;

import java.util.Scanner;

public class UseIllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số đo cạnh thứ 1 của tam giác : ");
        int side1 = scanner.nextInt();
        System.out.print("Nhập số đo cạnh thứ 2 của tam giác : ");
        int side2 = scanner.nextInt();
        System.out.print("Nhập số đo cạnh thứ 3 của tam giác : ");
        int side3 = scanner.nextInt();

        try {
            RightTriangle triangle = new RightTriangle(side1, side2, side3);
            System.out.println(triangle.toString());
        } catch (IllegalTriangleException instance) {
            System.out.println(instance.getThongBao());
        }
    }
}
