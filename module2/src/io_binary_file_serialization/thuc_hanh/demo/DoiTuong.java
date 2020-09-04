package io_binary_file_serialization.thuc_hanh.demo;

public class DoiTuong {
    private String sdt;
    private String nhom;
    private String ten;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String email;

    public DoiTuong() {
    }

    public DoiTuong(String sdt, String nhom, String ten, String gioiTinh, String diaChi, String ngaySinh, String email) {
        this.sdt = sdt;
        this.nhom = nhom;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String thongTin() {
        return "số : " + sdt + " , nhóm : " + nhom + " , tên : " + ten + " , giới tính : " + gioiTinh +
                " , địa chỉ : " + diaChi;
        //  + " , ngày sinh : " + ngaySinh + " , email : " + email
    }

    @Override
    public String toString() {
        return sdt + "," + nhom + "," + ten + "," + gioiTinh + "," + diaChi + "," + ngaySinh + "," + email;
    }
}
