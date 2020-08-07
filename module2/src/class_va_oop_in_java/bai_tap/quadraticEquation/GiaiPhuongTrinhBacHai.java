package class_va_oop_in_java.bai_tap.quadraticEquation;

import java.util.Scanner;

public class GiaiPhuongTrinhBacHai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soA;
        double soB;
        double soC;
        double delta;
        double nghiem1;
        double nghiem2;
        System.out.println("Phương trình bậc 2 có dạng : a(x^2) + bx + c = 0 :");
        System.out.print("Nhập số a : ");
        soA = scanner.nextDouble();
        System.out.print("Nhập số b : ");
        soB = scanner.nextDouble();
        System.out.print("Nhập số c : ");
        soC = scanner.nextDouble();
        if (soA == 0){
            if (soB == 0){
                if (soC == 0){
                    System.out.println("Phương trình vô số nghiệm .");
                }else System.out.println("Phương trình vô nghiệm .");
            }else {
                double root = -soC/soB;
                System.out.print("Phương trình có 1 nghiệm là : " + root);
            }
        }else {
            QuadraticEquation myQuadraticEquation = new QuadraticEquation(soA, soB, soC);
            delta = myQuadraticEquation.getDiscriminant();
            if (delta < 0){
                System.out.print("Phương trình vô nghiệm");
            }
            else if (delta == 0){
                nghiem1 = myQuadraticEquation.getRoot1();
                System.out.print("Phương trình có nghiệm kép là : " + nghiem1);
            }else {
                nghiem1 = myQuadraticEquation.getRoot1();
                nghiem2 = myQuadraticEquation.getRoot2();
                System.out.print("Phương trình có 2 nghiệm phân biệt là : " + nghiem1 + " và " + nghiem2);
            }
        }
    }
}
