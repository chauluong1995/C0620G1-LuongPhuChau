package bai_thi;

public class DanhBa {
    private String soDienThoai;
    private String nhom;
    private String ten;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String email;

    public DanhBa() {
    }

    public DanhBa(String soDienThoai, String nhom, String ten, String gioiTinh, String diaChi, String ngaySinh, String email) {
        this.soDienThoai = soDienThoai;
        this.nhom = nhom;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String sdt) {
        this.soDienThoai = sdt;
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
        return "số điện thoại : " + soDienThoai + " , nhóm : " + nhom + " , họ và tên : " + ten + " , giới tính : " + gioiTinh +
                " , địa chỉ : " + diaChi;
        //  + " , ngày sinh : " + ngaySinh + " , email : " + email
    }

    @Override
    public String toString() {
        return soDienThoai + "," + nhom + "," + ten + "," + gioiTinh + "," + diaChi + "," + ngaySinh + "," + email;
    }
}
