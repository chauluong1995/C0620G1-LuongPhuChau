package case_study.furama_resort.models;

import case_study.furama_resort.commons.Information;

public class Customer implements Information {
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String cmnd;
    private String soDienThoai;
    private String email;
    private String loaiKhach;
    private String diaChi;
    private Services dichVu;

    public Customer() {
    }

    public Customer(String hoTen, String ngaySinh, String gioiTinh, String cmnd, String soDienThoai, String email, String loaiKhach, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Services getDichVu() {
        return dichVu;
    }

    public void setDichVu(Services dichVu) {
        this.dichVu = dichVu;
    }

    @Override
    public String showInfor() {
        if (dichVu == null) {
            return " = Họ tên : " + hoTen + " , ngày sinh : " + ngaySinh + " , giới tính : " + gioiTinh + " , CMND : " + cmnd + " , số điện thoại : "
                    + soDienThoai + " , email : " + email + " , loại khách : " + loaiKhach + " , địa chỉ : " + diaChi;
        } else {
            return " = Họ tên : " + hoTen + " , ngày sinh : " + ngaySinh + " , giới tính : " + gioiTinh + " , CMND : " + cmnd + " , số điện thoại : "
                    + soDienThoai + " , email : " + email + " , loại khách : " + loaiKhach + " , địa chỉ : " + diaChi
                    + " dịch vụ " + dichVu.showInfor();
        }
    }
}
