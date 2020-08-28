package case_study.furama_resort.models;

public abstract class Services {
    private String id;
    private String tenDichVu;
    private String dienTichSuDung;
    private String chiPhiThue;
    private String soLuongNguoiToiDa;
    private String kieuThue;

    public Services() {
    }

    public Services(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
        this.kieuThue = kieuThue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(String dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public String getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(String chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getSoLuongNguoiToiDa() {
        return soLuongNguoiToiDa;
    }

    public void setSoLuongNguoiToiDa(String soLuongNguoiToiDa) {
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public abstract String showInfor();

    @Override
    public String toString() {
        return " = ID : " + id + " , tên dịch vụ : " + tenDichVu + " , diện tích sử dụng : " + dienTichSuDung + " , chi phí thuê : " + chiPhiThue +
                " , số lượng người tối đa : " + soLuongNguoiToiDa + " , kiểu thuê : " + kieuThue;
    }
}
