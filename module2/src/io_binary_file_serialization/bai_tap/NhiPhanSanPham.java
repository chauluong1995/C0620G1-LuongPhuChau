package io_binary_file_serialization.bai_tap;

import java.io.Serializable;

public class NhiPhanSanPham implements Serializable {
    private String tenSanPham;
    private String giaSanPham;
    private String maSanPham;
    private String hangSanXuat;
    private String moTaKhac;

    public NhiPhanSanPham() {
    }

    public NhiPhanSanPham(String maSanPham, String tenSanPham, String hangSanXuat, String giaSanPham, String moTaKhac) {
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

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
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
        return "Sản phẩm = Mã : " + maSanPham + " , tên : " + tenSanPham + " , hãng sản xuất : "
                + hangSanXuat + " , giá : " + giaSanPham + " , mô tả khác : " + moTaKhac;
    }
}
