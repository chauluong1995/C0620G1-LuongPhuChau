package io_binary_file_serialization.bai_tap;

public class NhiPhanSanPham {
    private String tenSanPham;
    private float giaSanPham;
    private int maSanPham;
    private String hangSanXuat;
    private String moTaKhac;

    public NhiPhanSanPham() {
    }

    public NhiPhanSanPham(int maSanPham, String tenSanPham, String hangSanXuat, float giaSanPham, String moTaKhac) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.maSanPham = maSanPham;
        this.hangSanXuat = hangSanXuat;
        this.moTaKhac = moTaKhac;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(float giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getMoTaKhac() {
        return moTaKhac;
    }

    public void setMoTaKhac(String moTaKhac) {
        this.moTaKhac = moTaKhac;
    }

    @Override
    public String toString() {
        return "Sản phẩm : maSanPham " + maSanPham + " , tenSanPham " + tenSanPham + " , hangSanXuat "
                + hangSanXuat + " , giaSanPham " + giaSanPham + " , moTaKhac " + moTaKhac;
    }
}
