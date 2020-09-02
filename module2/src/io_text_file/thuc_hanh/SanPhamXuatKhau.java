package io_text_file.thuc_hanh;

public class SanPhamXuatKhau extends SanPham {
    private String giaXuatKhau;
    private String quocGiaNhapSanPham;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(int id, String maSanPham, String tenSanPham, String giaSanPham, String soLuongSanPham, String nhaSanXuat,
                           String giaXuatKhau, String quocGiaNhapSanPham) {
        super(id, maSanPham, tenSanPham, giaSanPham, soLuongSanPham, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public String getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(String giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return " = id : " + this.getId() + " , mã sản phẩm : " + this.getMaSanPham() + " , tên sản phẩm : " + this.getTenSanPham() +
                " , giá sản phẩm : " + this.getGiaSanPham() + " , số lượng sản phẩm : " + this.getSoLuongSanPham() + " , nhà sản xuất : " +
                this.getNhaSanXuat()
                + " , giá xuất khẩu : " + giaXuatKhau + " , quốc gia nhập sản phẩm : " + quocGiaNhapSanPham;
    }
}
