package java_collection_framework.bai_tap.optional_my_bst;

import java_collection_framework.thuc_hanh.cay_tim_kiem_nhi_phan.TreeNodeOptional;

public class MyBST<E extends Comparable<E>> {
    protected TreeNodeOptional<E> root;
    protected int size = 0;

    public MyBST() {
    }

    public MyBST(E value) {
        insert(value);
    }

    public void insert(E value) {
        if (root == null) root = new TreeNodeOptional<>(value);
        else {
            if (value.compareTo(browserForInsert(value).element) < 0) {
                browserForInsert(value).left = new TreeNodeOptional<>(value);
            } else browserForInsert(value).right = new TreeNodeOptional<>(value);
        }
        size++;
    }

    public TreeNodeOptional<E> browserForInsert(E value) {
        TreeNodeOptional<E> parent = null;
        TreeNodeOptional<E> current = root;
        while (current != null) {
            if (value.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (value.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
        }
        return parent;
    }

    public void remove(E value) {
        if (root == null) return;
        else root = deleteNode(root, value);
        size--;
    }

    public TreeNodeOptional<E> deleteNode(TreeNodeOptional<E> root, E value) {
        if (value.compareTo(root.element) < 0) {
            root.left = deleteNode(root.left, value);
        } else {
            if (value.compareTo(root.element) > 0) {
                root.right = deleteNode(root.right, value);
            } else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                TreeNodeOptional<E> temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                E minAtRight = temp.element;
                root.element = minAtRight;
                root.right = deleteNode(root.right, minAtRight);
            }
        }
        return root;
    }

    public boolean search(E value) {
        return searchMyBST(value, root);
    }

    public boolean leftBrowser(E value, TreeNodeOptional<E> root) {
        return value.compareTo(root.element) < 0;
    }

    public boolean rightBrowser(E value, TreeNodeOptional<E> root) {
        return value.compareTo(root.element) > 0;
    }

    public boolean searchMyBST(E value, TreeNodeOptional<E> root) {
        if (root == null) return false;
        if (leftBrowser(value, root)) return searchMyBST(value, root.left);
        else if (rightBrowser(value, root)) return searchMyBST(value, root.right);
        else return true;
    }

    public int getSize() {
        return size;
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(TreeNodeOptional<E> root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(TreeNodeOptional<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.element + " ");
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
            System.out.print(root.element + " ");
        }
    }
}
