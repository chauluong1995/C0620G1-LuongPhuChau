package ke_thua.bai_tap.triangle;

import java.util.Scanner;

public class DemoTriangle {
    public static void main(String[] args) {
        Triangle triangle_1 = new Triangle();
        Triangle triangle_2 = new Triangle(10, 10, 10);
        triangle_2.setColor("yellow");

        System.out.println("Triangle 1 " + triangle_1.toString());
        System.out.println("Triangle 2 " + triangle_2.toString());

        Scanner scanner = new Scanner(System.in);
        double side1;
        double side2;
        double side3;
        String color;

        System.out.print("Input color of triangle : ");
        color = scanner.nextLine();

        do {
            do {
                System.out.print("Input side 1 of triangle : ");
                side1 = scanner.nextDouble();
                if (side1 > 0) {
                    break;
                } else System.out.println("Side 1 of triangle not invalid !");
            } while (true);

            do {
                System.out.print("Input side 2 of triangle : ");
                side2 = scanner.nextDouble();
                if (side2 > 0) {
                    break;
                } else System.out.println("Side 2 of triangle not invalid !");
            } while (true);

            do {
                System.out.print("Input side 3 of triangle : ");
                side3 = scanner.nextDouble();
                if (side3 > 0) {
                    break;
                } else System.out.println("Side 3 of triangle not invalid !");
            } while (true);

            if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {
                break;
            } else System.out.println("Triangle of you not invalid !");
        } while (true);

//        System.out.print("Input color of triangle : ");
//        color = scanner.nextLine();

        Triangle triangle_3 = new Triangle(side1, side2, side3);
        triangle_3.setColor(color);

        System.out.print("Triangle 3 " + triangle_3.toString());
    }
}
