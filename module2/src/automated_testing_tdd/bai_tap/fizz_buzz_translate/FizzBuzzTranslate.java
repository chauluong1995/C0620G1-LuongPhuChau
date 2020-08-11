package automated_testing_tdd.bai_tap.fizz_buzz_translate;

public class FizzBuzzTranslate {
    public static String translate(int number) {
        if (number > 0 && number < 100) {

            // if ở đây kiểm tra number không chia hết cho cả 3 và 5 thì kiểm tra chứa số 3;5 và đọc số .
            if (kiemTraChiaHetCho3Va5(number).equals("")) {
                String result = "";

                // if ở đây kiểm tra number không chứa cả 2 số 3 và 5 thì chỉ tiến hành đọc số .
                if (kiemTraChuaSo3Va5(number).equals("")) {
                    result += docSoThanhChu(number);

                    // number có chứa ít nhất 1 trong 2 số 3 và 5 thì in ra theo yêu cầu rồi đọc số .
                } else {
                    result = kiemTraChuaSo3Va5(number);
                    result += " " + docSoThanhChu(number);
                }
                return result;

                // number chia hết cho ít nhất 1 trong 2 số 3 và 5 thì in ra theo yêu cầu .
            } else return kiemTraChiaHetCho3Va5(number);
        } else return "Invalid Number !";
    }

    public static String kiemTraChiaHetCho3Va5(int number) {
        String result = "";
        if (number % 3 == 0) {
            if (number % 5 == 0) {
                result += "FizzBuzz";
            } else result += "Fizz";
        } else if (number % 5 == 0) {
            result += "Buzz";
        }
        return result;
    }

    public static String kiemTraChuaSo3Va5(int number) {
        String result = "";
        int soHangChuc = number / 10;
        int soHangDonVi = number - soHangChuc * 10;
        if (soHangChuc == 3) {
            result += "Fizz";
        }
        if (soHangChuc == 5) {
            result += "Buzz";
        }
        if (soHangDonVi == 3) {
            result += "Fizz";
        }
        if (soHangDonVi == 5) {
            result += "Buzz";
        }
        return result;
    }

    public static String docSoThanhChu(int number) {
        String result = "";
        int soHangChuc = 0;
        int soHangDonVi;
        if (number < 10) {
            soHangDonVi = number;
        } else {
            soHangChuc = number / 10;
            soHangDonVi = number - soHangChuc * 10;
        }
        if (soHangChuc > 0) {
            switch (soHangChuc) {
                case 1:
                    result += "Mười ";
                    break;
                case 2:
                    result += "Hai Mươi ";
                    break;
                case 3:
                    result += "Ba Mươi ";
                    break;
                case 4:
                    result += "Bốn Mươi ";
                    break;
                case 5:
                    result += "Năm Mươi ";
                    break;
                case 6:
                    result += "Sáu Mươi ";
                    break;
                case 7:
                    result += "Bảy Mươi ";
                    break;
                case 8:
                    result += "Tám Mươi ";
                    break;
                case 9:
                    result += "Chín Mươi ";
                    break;
            }
        }
        switch (soHangDonVi) {
            case 1:
                if (soHangChuc > 1) {
                    result += "Mốt";
                } else result += "Một";
                break;
            case 2:
                result += "Hai";
                break;
            case 3:
                result += "Ba";
                break;
            case 4:
                result += "Bốn";
                break;
            case 5:
                result += "Lăm";
                break;
            case 6:
                result += "Sáu";
                break;
            case 7:
                result += "Bảy";
                break;
            case 8:
                result += "Tám";
                break;
            case 9:
                result += "Chín";
                break;
        }
        return result;
    }
}
