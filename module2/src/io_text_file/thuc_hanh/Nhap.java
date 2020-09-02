package io_text_file.thuc_hanh;

public class Nhap extends SanPham {
    private String giaNhapKhau;
    private String tinhThanhNhap;
    private String thueNhapKhau;

    public Nhap() {
    }

    public Nhap(int id, String maSanPham, String tenSanPham, String giaSanPham, String soLuongSanPham, String nhaSanXuat,
                String giaNhapKhau, String tinhThanhNhap, String thueNhapKhau) {
        super(id, maSanPham, tenSanPham, giaSanPham, soLuongSanPham, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public String getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(String giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public String getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(String thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return " = id : " + this.getId() + " , mã sản phẩm : " + this.getMaSanPham() + " , tên sản phẩm : " + this.getTenSanPham() +
                " , giá sản phẩm : " + this.getGiaSanPham() + " , số lượng sản phẩm : " + this.getSoLuongSanPham() + " , nhà sản xuất : " +
                this.getNhaSanXuat() + " , giá nhập khẩu : "
                + this.giaNhapKhau + " , tỉnh thành nhập : " + this.tinhThanhNhap + " , thuế nhập khẩu : " + this.thueNhapKhau;
    }
}
