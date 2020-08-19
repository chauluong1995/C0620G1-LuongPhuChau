package xu_li_ngoai_le_va_debug.bai_tap;

public class IllegalTriangleException extends Exception {
    String thongBao;

    public IllegalTriangleException(String baoLoi){
        thongBao = baoLoi;
    }

    public String getThongBao(){
        return thongBao;
    }
}
