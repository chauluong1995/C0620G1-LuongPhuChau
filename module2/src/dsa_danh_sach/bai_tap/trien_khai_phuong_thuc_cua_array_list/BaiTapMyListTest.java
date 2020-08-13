package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_array_list;

public class BaiTapMyListTest {
    public static void main(String[] args) {
        BaiTapMyList<Integer> baiTapMyList = new BaiTapMyList<>(5);

        baiTapMyList.add(0, 1996);
        baiTapMyList.add(0, 8);
        baiTapMyList.add(1, 10);
        baiTapMyList.add(0, 27);
        baiTapMyList.add(1, 5);
        baiTapMyList.add(2, 1995);
        System.out.println("List hiện tại là : " + baiTapMyList);
        System.out.println("Số lượng phần tử trong list là : " + baiTapMyList.size());

        baiTapMyList.add(1, 2001);
        System.out.print(baiTapMyList + " và số cần xóa là : ");
        System.out.print(baiTapMyList.remove(1) + " , sau khi xóa : ");
        System.out.println(baiTapMyList);

        baiTapMyList.add(2020);
        System.out.println("List sau khi thêm phần tử 2020 vào cuối là : " + baiTapMyList);

        baiTapMyList.clone();
        System.out.println("Sau khi clone : " + baiTapMyList);

        System.out.print("Phần tử 1995 có trong list nên " + baiTapMyList.contains(1995) + " còn ");
        System.out.println("phần tử 1997 không có nên " + baiTapMyList.contains(1997));

        System.out.print("Vị trí của phần tử 1995 là : " + baiTapMyList.indexOf(1995) + " còn ");
        System.out.println("phần tử 1999 không có trong list nên là : " + baiTapMyList.indexOf(1999));

        System.out.println("Phần tử tại vị trí thứ 2 là : " + baiTapMyList.get(2));

        baiTapMyList.clear();
        System.out.println("Sau khi clear thì list trở thành : " + baiTapMyList);
    }
}
