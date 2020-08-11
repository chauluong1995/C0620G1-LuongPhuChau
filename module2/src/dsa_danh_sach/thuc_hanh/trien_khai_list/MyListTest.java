package dsa_danh_sach.thuc_hanh.trien_khai_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(5);
        listInteger.add(6);

        System.out.println("element 0: " + listInteger.get(0));
        System.out.println("element 2: " + listInteger.get(2));
        System.out.println("element 3: " + listInteger.get(3));

//        listInteger.get(6);
//        System.out.println("element 6: "+listInteger.get(6));
//
//        listInteger.get(-1);
//        System.out.println("element -1: " + listInteger.get(-1));
    }
}
