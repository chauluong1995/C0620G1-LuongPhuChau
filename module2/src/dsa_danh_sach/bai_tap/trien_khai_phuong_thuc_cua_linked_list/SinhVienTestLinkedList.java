package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linked_list;

public class SinhVienTestLinkedList {
    private String name;

    SinhVienTestLinkedList() {
    }

    SinhVienTestLinkedList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
