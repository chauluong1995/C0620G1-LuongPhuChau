package case_study.furama_resort.models;

public class Employee {
    private String maSoNhanVien;
    private String hoTen;
    private String tuoi;
    private String diaChi;

    public Employee() {
    }

    public Employee(String maSoNhanVien, String hoTen, String tuoi, String diaChi) {
        this.maSoNhanVien = maSoNhanVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    public String getMaSoNhanVien() {
        return maSoNhanVien;
    }

    public void setMaSoNhanVien(String maSoNhanVien) {
        this.maSoNhanVien = maSoNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return " mã số nhân viên : " + maSoNhanVien + " , họ và tên : " + hoTen + " , tuổi : " + tuoi + " , địa chỉ : " + diaChi;
    }
}
