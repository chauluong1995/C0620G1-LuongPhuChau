package java_collection_framework.thuc_hanh.cay_tim_kiem_nhi_phan;

public class TestBSTOptional {
    public static void main(String[] args) {
        //create a BST
        BSTOptional<String> tree = new BSTOptional<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
