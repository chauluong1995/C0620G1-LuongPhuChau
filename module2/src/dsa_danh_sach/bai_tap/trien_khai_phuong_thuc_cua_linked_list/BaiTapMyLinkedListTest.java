package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linked_list;

public class BaiTapMyLinkedListTest {
    public static void main(String[] args) {
        BaiTapMyLinkedList<Integer> baiTapMyLinkedList = new BaiTapMyLinkedList<>(27);
        baiTapMyLinkedList.printList();

        baiTapMyLinkedList.addLast(5);
        baiTapMyLinkedList.addLast(1999);
        baiTapMyLinkedList.printList();

        baiTapMyLinkedList.add(1995,2);
        baiTapMyLinkedList.printList();

        baiTapMyLinkedList.addFirst(1996);
        baiTapMyLinkedList.printList();

        System.out.println(baiTapMyLinkedList.remove(0));
        System.out.println(baiTapMyLinkedList.remove(4));
        System.out.println(baiTapMyLinkedList.remove(4));
        baiTapMyLinkedList.printList();
    }
}
