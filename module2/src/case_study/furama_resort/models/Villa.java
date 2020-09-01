package case_study.furama_resort.models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private String dienTichHoBoi;
    private String soTang;

    public Villa() {
    }

    public Villa(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue,
                 String tieuChuanPhong, String moTaTienNghiKhac, String dienTichHoBoi, String soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghi() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghi(String moTaTienNghi) {
        this.moTaTienNghiKhac = moTaTienNghi;
    }

    public String getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(String dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    @Override
    public String showInfor() {
        return super.toString() + " , tiêu chuẩn phòng : " + tieuChuanPhong + " , mô tả tiện nghi khác : "
                + moTaTienNghiKhac + " , diện tích hồ bơi : " + dienTichHoBoi + " , số tầng : " + soTang;
    }

    @Override
    public String toString() {
        return super.toString() + " , tiêu chuẩn phòng : " + tieuChuanPhong + " , mô tả tiện nghi khác : "
                + moTaTienNghiKhac + " , diện tích hồ bơi : " + dienTichHoBoi + " , số tầng : " + soTang;
    }
}
