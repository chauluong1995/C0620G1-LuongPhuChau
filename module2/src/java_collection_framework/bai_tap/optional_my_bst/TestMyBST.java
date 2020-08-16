package java_collection_framework.bai_tap.optional_my_bst;

public class TestMyBST {
    public static void main(String[] args) {
        MyBST<String> stringMyBST = new MyBST<>();
        MyBST<Integer> myBST = new MyBST<>(27);
        myBST.insert(5);
        myBST.insert(1995);
        myBST.insert(18);
        myBST.insert(15);
        myBST.insert(2003);

        myBST.preorder();
        System.out.println();

        myBST.inorder();
        System.out.println();

        myBST.postorder();
        System.out.println();
        System.out.println(myBST.size);

        myBST.remove(27);
        myBST.inorder();
        System.out.println();
        System.out.println(myBST.size);

        System.out.println(myBST.search(1995));

        stringMyBST.inorder();
    }
}
