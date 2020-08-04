package loops.bai_tap;
import java.util.Scanner;
public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        System.out.println("Menu : ");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.print("Enter your choice : ");
        Scanner input = new Scanner(System.in);
        while (true){
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Print the rectangle");
                    for (byte i=0;i<3;i++){
                        for (byte j=0;j<10;j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.print("Enter your choice: ");
                    break;
                case 2:
                    System.out.println("Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
                    for (byte i=0;i<5;i++){
                        for (byte j=i;j<5;j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for(byte i=0,j;i<=5;i++){
                        for(j=1;j<=i;j++){
                            System.out.print(" ");
                        }
                        for(i=5;i>=j;i--){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (byte i=0; i<5; i++){
                        for (byte j=0; j<=i; j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for(byte i=4,j;i>=0;i--){
                        for(j=1;j<=i;j++){
                            System.out.print(" ");
                        }
                        for(j=4;j>=i;j--){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.print("Enter your choice: ");
                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    for(byte i=1,j;i<=5;i++){
                        for(j=1;j<=5-i;j++){
                            System.out.print(" ");
                        }
                        for(j=1;j<=2*i-1;j++){
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.print("Enter your choice: ");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
                    System.out.print("Enter your choice: ");
            }
        }
    }
}
