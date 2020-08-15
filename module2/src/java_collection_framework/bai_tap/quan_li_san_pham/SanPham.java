package java_collection_framework.bai_tap.quan_li_san_pham;

public class SanPham {
    private String tenSanPham;
    private float giaSanPham;

    public SanPham() {
    }

    public SanPham(String tenSanPham, float giaSanPham) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
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

    @Override
    public String toString() {
        return "Tên : " + tenSanPham + " + giá : " + giaSanPham;
    }
}
