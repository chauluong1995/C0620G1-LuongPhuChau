package java_collection_framework.thuc_hanh.cay_tim_kiem_nhi_phan;

public class BSTOptional<E extends Comparable<E>> extends AbstractTreeOptional<E> {
    protected TreeNodeOptional<E> root;
    protected int size = 0;

    public BSTOptional() {
    }

    public BSTOptional(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNodeOptional<E> parent = null;
            TreeNodeOptional<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNodeOptional<E> createNewNode(E e) {
        return new TreeNodeOptional<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(TreeNodeOptional<E> root) {
        if (root != null) {
            System.out.println(root.element);
            preorder(root.left);
            preorder(root.right);
        }
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    public void inorder(TreeNodeOptional<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.element);
            inorder(root.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    public void postorder(TreeNodeOptional<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.element);
        }
    }
}
