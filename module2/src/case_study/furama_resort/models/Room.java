package case_study.furama_resort.models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }

    public Room(String id, String tenDichVu, String dienTichSuDung, String chiPhiThue, String soLuongNguoiToiDa, String kieuThue,
                String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public String showInfor() {
        return super.toString() + " , dịch vụ miễn phí đi kèm : " + dichVuMienPhiDiKem;
    }
}
