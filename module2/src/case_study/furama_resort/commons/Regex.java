package case_study.furama_resort.commons;

import case_study.furama_resort.libs.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static Scanner scanner = new Scanner(System.in);

    public static String kiemTraID(String loaiDichVu) {
        final String ID_REGEX = "^SV" + loaiDichVu + "-\\d{4}$";
        String id;
        do {
            Pattern pattern = Pattern.compile(ID_REGEX);
            System.out.print("Nhập id : ");
            id = scanner.nextLine();
            Matcher matcher = pattern.matcher(id);
            if (matcher.matches()) break;
            else {
                System.out.println("ID không hợp lệ ! Định dạng ID hợp lệ : SVXX-YYYY\nVới YYYY là các số từ 0-9\nVà XX là :" +
                        "\nNếu Villa thì XX sẽ là VL" +
                        "\nNếu House thì XX sẽ là HO" +
                        "\nNếu Room thì XX sẽ là RO");
            }
        } while (true);
        return id;
    }

    public static String kiemTraTenDichVu(String tenDungCuaDichVu) {
        String nhapTen;
        do {
            System.out.print("Nhập tên dịch vụ : ");
            nhapTen = scanner.nextLine();
            if (tenDungCuaDichVu.equals("Villa")) {
                if (nhapTen.matches("^(Villa)(\\s(\\w)+)+$")) break;
            }
            if (tenDungCuaDichVu.equals("House")) {
                if (nhapTen.matches("^(House)(\\s(\\w)+)+$")) break;
            }
            if (tenDungCuaDichVu.equals("Room")) {
                if (nhapTen.matches("^(Room)(\\s(\\w)+)+$")) break;
            }
            System.out.println("Tên dịch vụ không hợp lệ !");
        } while (true);
        return nhapTen;
    }

    public static String kiemTraDienTich(String loaiDienTich) {
        String dienTich;
        do {
            System.out.print("Nhập diện tích " + loaiDienTich + " : ");
            dienTich = scanner.nextLine();
            if (kiemTraNhapSoThuc(dienTich) && Float.parseFloat(dienTich) > 30) break;
            else System.out.println("Diện tích" + loaiDienTich + " phải là số thực lớn hơn 30 !");
        } while (true);
        return dienTich;
    }

    public static String kiemTraChiPhiThue() {
        String chiPhiThue;
        do {
            System.out.print("Nhập chi phí thuê : ");
            chiPhiThue = scanner.nextLine();
            if (kiemTraNhapSoThuc(chiPhiThue) && Float.parseFloat(chiPhiThue) > 0) break;
            else System.out.println("Chi phí thuê phải là số dương !");
        } while (true);
        return chiPhiThue;
    }

    public static String kiemTraSoLuongNguoiToiDa() {
        String soLuongNguoiToiDa;
        do {
            System.out.print("Nhập số lượng người tối đa : ");
            soLuongNguoiToiDa = scanner.nextLine();
            if (kiemTraNhapSoNguyen(soLuongNguoiToiDa) && Integer.parseInt(soLuongNguoiToiDa) > 0 && Integer.parseInt(soLuongNguoiToiDa) < 20)
                break;
            else System.out.println("Số lượng người tối đa phải > 0 và nhỏ hơn < 20 !");
        } while (true);
        return soLuongNguoiToiDa;
    }

    public static String kiemTraDichVuDiKem() {
        String dichVuDiKem;
        do {
            System.out.print("Nhập dịch vụ miễn phí đi kèm : ");
            dichVuDiKem = scanner.nextLine();
            if (dichVuDiKem.matches("^(massage)|(karaoke)|(food)|(drink)|(car)$")) break;
                // ^(massage|karaoke|food|drink|car)([,](massage|karaoke|food|drink|car)){0,4}$
            else System.out.println("Dịch vụ đi kèm phải là 1 trong các giá trị: massage, karaoke, food, drink, car !");
        } while (true);
        return dichVuDiKem;
    }

    public static String kiemTraSoTang() {
        String soTang;
        do {
            System.out.print("Nhập số tầng : ");
            soTang = scanner.nextLine();
            if (kiemTraNhapSoNguyen(soTang) && Integer.parseInt(soTang) > 0) break;
            else System.out.println("Số tầng phải là số nguyên dương !");
        } while (true);
        return soTang;
    }

    public static String chuanHoaDuLieu(String duLieu) {
        duLieu = duLieu.toLowerCase();
        duLieu = Character.toUpperCase(duLieu.charAt(0)) + duLieu.substring(1);
        return duLieu;
    }

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap) {
        return nhap.matches("\\d+([.]\\d+)?");
    }

    public static String kiemTraTen() {
        String ten;
        do {
            try {
                System.out.print("Nhập họ và tên : ");
                //System.out.flush();
                ten = scanner.nextLine();
                // if (ten.matches("^[A-Z]([a-z]*)(\\s[A-Z]([a-z]*))*")) break;
                if (ten.matches("^\\p{Lu}((\\p{Ll})*)(\\s\\p{Lu}(\\p{Ll})*)*$")) break;
                else throw new NameException();
            } catch (NameException n) {
                //System.err.println("Lỗi : Tên khách hàng phải in hoa ký tự đầu tiên của mỗi từ và không có khoảng trắng dư thừa !");
                //System.err.flush();
                System.out.println("Tên khách hàng phải in hoa ký tự đầu tiên của mỗi từ và không có khoảng trắng dư thừa !");
            }
        } while (true);
        return ten;
    }

    public static String kiemTraEmail() {
        String email;
        do {
            try {
                System.out.print("Nhập email : ");
                email = scanner.nextLine();
                if (email.matches("^\\w+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$")) break;
                else throw new EmailException();
            } catch (EmailException e) {
                System.out.println("Email phải đúng định dạng abc@abc.abc !");
            }
        } while (true);
        return email;
    }

    public static String kiemTraGioiTinh() {
        String gioiTinh;
        do {
            try {
                System.out.print("Nhập giới tính : ");
                gioiTinh = scanner.nextLine();
                if (gioiTinh.matches("^([Mm][Aa][Ll][Ee])|([Ff][Ee][Mm][Aa][Ll][Ee])|([Uu][Nn][Kk][Nn][Oo][Ww])$")) {
                    gioiTinh = gioiTinh.toLowerCase();
                    gioiTinh = Character.toUpperCase(gioiTinh.charAt(0)) + gioiTinh.substring(1);
                    break;
                } else throw new GenderException();
            } catch (GenderException g) {
                System.out.println("Giới tính bạn nhập không hợp lệ ! Giới tính phải là Male hoặc Female hoặc Unknow !");
            }
        } while (true);
        return gioiTinh;
    }

    public static String kiemTraCMND() {
        String cmnd;
        do {
            try {
                System.out.print("Nhập số chứng minh nhân dân : ");
                cmnd = scanner.nextLine();
                if (cmnd.matches("^(\\d{3}\\s){2}\\d{3}$")) break;
                else throw new IdCardException();
            } catch (IdCardException i) {
                System.out.println("CMND phải có 9 chữ số và theo định dạng XXX XXX XXX !");
            }
        } while (true);
        return cmnd;
    }

    public static String kiemTraNgaySinh() {
        String ngaySinh;
        do {
            try {
                System.out.print("Nhập ngày tháng năm sinh : ");
                ngaySinh = scanner.nextLine();
                if (ngaySinh.matches("^((0[1-9])|([1-2]\\d)|(3[0-1]))[/]((0[1-9])|(1[0-2]))[/]((19\\d{2})|(200[0-2]))$"))
                    break;
                else throw new BirthdayException();
            } catch (BirthdayException b) {
                System.out.println("Năm sinh phải > 1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy !");
            }
        } while (true);
        return ngaySinh;
    }
}
