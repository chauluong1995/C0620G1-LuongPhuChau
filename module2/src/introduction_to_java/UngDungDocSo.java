package introduction_to_java;
import java.util.Scanner;
public class UngDungDocSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number,donVi,hangChucNho,hangChucLon,hangTram;
        System.out.print("Nhập số cần đọc : ");
        number = scanner.nextInt();
        donVi = -1;
        hangChucNho = -1;
        hangChucLon = -1;
        hangTram = -1;
        if (number < 10 && number >= 0){
            if (number > 0){
                donVi = number;
            }else System.out.print("Không");
        }
        else if (number < 20){
            hangChucNho = number - 10;
            switch (hangChucNho){
                case 0 :
                    System.out.print("Mười");
                    break;
                case 1 :
                    System.out.print("Mười một");
                    break;
                case 2 :
                    System.out.print("Mười hai");
                    break;
                case 3 :
                    System.out.print("Mười ba");
                    break;
                case 4 :
                    System.out.print("Mười bốn");
                    break;
                case 5 :
                    System.out.print("Mười lăm");
                    break;
                case 6 :
                    System.out.print("Mười sáu");
                    break;
                case 7 :
                    System.out.print("Mười bảy");
                    break;
                case 8 :
                    System.out.print("Mười tám");
                    break;
                case 9 :
                    System.out.print("Mười chín");
                    break;
            }
        }
        else if (number < 100){
            hangChucLon = number / 10;
            donVi = number - hangChucLon*10;
        }
        else if (number <= 999){
            if (number > 100){
                hangTram = number / 100;
                hangChucLon = (number - hangTram*100)/10;
                donVi = number - (hangTram*100 + hangChucLon*10);
            }else System.out.print("Một trăm ");
        }else System.out.print("Out of ability");
        switch (hangTram){
            case 1 :
                System.out.print("Một trăm ");
                break;
            case 2 :
                System.out.print("Hai trăm ");
                break;
            case 3 :
                System.out.print("Ba trăm ");
                break;
            case 4 :
                System.out.print("Bốn trăm ");
                break;
            case 5 :
                System.out.print("Năm trăm ");
                break;
            case 6 :
                System.out.print("Sáu trăm ");
                break;
            case 7 :
                System.out.print("Bảy trăm ");
                break;
            case 8 :
                System.out.print("Tám trăm ");
                break;
            case 9 :
                System.out.print("Chín trăm ");
                break;
        }
        switch (hangChucLon){
            case 0 :
                System.out.print("Lẻ ");
                break;
            case 1 :
                System.out.print("Mười ");
                break;
            case 2 :
                System.out.print("Hai mươi ");
                break;
            case 3 :
                System.out.print("Ba mươi ");
                break;
            case 4 :
                System.out.print("Bốn mươi ");
                break;
            case 5 :
                System.out.print("Năm mươi ");
                break;
            case 6 :
                System.out.print("Sáu mươi ");
                break;
            case 7 :
                System.out.print("Bảy mươi ");
                break;
            case 8 :
                System.out.print("Tám mươi ");
                break;
            case 9 :
                System.out.print("Chín mươi ");
                break;
        }
        switch (donVi){
            case 0 :
                System.out.print("");
                break;
            case 1 :
                System.out.print("Một");
                break;
            case 2 :
                System.out.print("Hai");
                break;
            case 3 :
                System.out.print("Ba");
                break;
            case 4 :
                System.out.print("Bốn");
                break;
            case 5 :
                System.out.print("Năm");
                break;
            case 6 :
                System.out.print("Sáu");
                break;
            case 7 :
                System.out.print("Bảy");
                break;
            case 8 :
                System.out.print("Tám");
                break;
            case 9 :
                System.out.print("Chín");
                break;
        }
    }
}
