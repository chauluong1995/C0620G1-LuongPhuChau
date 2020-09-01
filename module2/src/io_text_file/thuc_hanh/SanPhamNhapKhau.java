package io_text_file.thuc_hanh;

public class SanPhamNhapKhau extends SanPham {
    private String giaNhapKhau;
    private String tinhThanhNhap;
    private String thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(int id, String maSanPham, String tenSanPham, String giaSanPham, String soLuongSanPham, String nhaSanXuat,
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
        return super.toString() + " , giá nhập khẩu : " + giaNhapKhau + " , tỉnh thành nhập : " + tinhThanhNhap
                + " , thuế nhập khẩu : " + thueNhapKhau;
    }
}
