package introduction_to_java;

import java.util.Scanner;

public class UngDungDocSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, donVi, hangChuc, hangTram;
        System.out.print("Nhập số cần đọc : ");
        number = scanner.nextInt();
        donVi = -1;
        hangChuc = -1;
        hangTram = 0;
        if (number == 0) {
            System.out.print("Không");
        } else if (number > 0 && number <= 999) {
            if (number < 10) {
                donVi = number;
            } else if (number < 100) {
                hangChuc = number / 10;
                donVi = number - hangChuc * 10;
            } else {
                hangTram = number / 100;
                hangChuc = (number - hangTram * 100) / 10;
                donVi = number - (hangTram * 100 + hangChuc * 10);
                if (hangChuc == 0 && donVi == 0) {
                    hangChuc = -1;
                    donVi = -1;
                }
            }
            if (hangTram > 0) {
                switch (hangTram) {
                    case 1:
                        System.out.print("Một trăm ");
                        break;
                    case 2:
                        System.out.print("Hai trăm ");
                        break;
                    case 3:
                        System.out.print("Ba trăm ");
                        break;
                    case 4:
                        System.out.print("Bốn trăm ");
                        break;
                    case 5:
                        System.out.print("Năm trăm ");
                        break;
                    case 6:
                        System.out.print("Sáu trăm ");
                        break;
                    case 7:
                        System.out.print("Bảy trăm ");
                        break;
                    case 8:
                        System.out.print("Tám trăm ");
                        break;
                    case 9:
                        System.out.print("Chín trăm ");
                        break;
                }
            }
            if (hangChuc > -1) {
                switch (hangChuc) {
                    case 0:
                        System.out.print("Lẻ ");
                        break;
                    case 1:
                        System.out.print("Mười ");
                        break;
                    case 2:
                        System.out.print("Hai mươi ");
                        break;
                    case 3:
                        System.out.print("Ba mươi ");
                        break;
                    case 4:
                        System.out.print("Bốn mươi ");
                        break;
                    case 5:
                        System.out.print("Năm mươi ");
                        break;
                    case 6:
                        System.out.print("Sáu mươi ");
                        break;
                    case 7:
                        System.out.print("Bảy mươi ");
                        break;
                    case 8:
                        System.out.print("Tám mươi ");
                        break;
                    case 9:
                        System.out.print("Chín mươi ");
                        break;
                }
            }
            if (donVi > -1) {
                switch (donVi) {
                    case 0:
                        System.out.print("");
                        break;
                    case 1:
                        if (hangChuc > 1) {
                            System.out.print("Mốt");
                        } else System.out.print("Một");
                        break;
                    case 2:
                        System.out.print("Hai");
                        break;
                    case 3:
                        System.out.print("Ba");
                        break;
                    case 4:
                        System.out.print("Bốn");
                        break;
                    case 5:
                        if (hangChuc > 0) {
                            System.out.print("Lăm");
                        } else System.out.print("Năm");
                        break;
                    case 6:
                        System.out.print("Sáu");
                        break;
                    case 7:
                        System.out.print("Bảy");
                        break;
                    case 8:
                        System.out.print("Tám");
                        break;
                    case 9:
                        System.out.print("Chín");
                        break;
                }
            }
        } else System.out.print("Out of ability");
    }
}
