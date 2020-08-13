package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linked_list;

public class BaiTapMyLinkedListTest {
    public static void main(String[] args) {
        SinhVienTestLinkedList sinhVien_1 = new SinhVienTestLinkedList("Bài");
        SinhVienTestLinkedList sinhVien_2 = new SinhVienTestLinkedList("Này");
        SinhVienTestLinkedList sinhVien_3 = new SinhVienTestLinkedList("Khó");
        SinhVienTestLinkedList sinhVien_4 = new SinhVienTestLinkedList("Quá");
        SinhVienTestLinkedList sinhVien_5 = new SinhVienTestLinkedList("Chừng");

        BaiTapMyLinkedList<Object> baiTapMyLinkedList = new BaiTapMyLinkedList<>();
        baiTapMyLinkedList.addFirst(sinhVien_2);
        baiTapMyLinkedList.addFirst(sinhVien_1);
        baiTapMyLinkedList.addLast(sinhVien_3);
        baiTapMyLinkedList.add(sinhVien_5,3);
        baiTapMyLinkedList.add(sinhVien_4,3);
        baiTapMyLinkedList.printList();

        System.out.println(baiTapMyLinkedList.remove(sinhVien_3));
        baiTapMyLinkedList.printList();

        System.out.println(baiTapMyLinkedList.get(1));
        System.out.println(baiTapMyLinkedList.size());
    }
}
