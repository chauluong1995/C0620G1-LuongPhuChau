package io_text_file.thuc_hanh;

import java.util.Comparator;

public class SapXepSanPham implements Comparator<SanPham> {

    @Override
    public int compare(SanPham sanPham_1, SanPham sanPham_2) {
        int ketQua = Integer.parseInt(sanPham_1.getGiaSanPham()) - Integer.parseInt(sanPham_2.getGiaSanPham());
        if (ketQua != 0) return ketQua;
        else return sanPham_1.getTenSanPham().compareTo(sanPham_2.getTenSanPham());
    }
}
