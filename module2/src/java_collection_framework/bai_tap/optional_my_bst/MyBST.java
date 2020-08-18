package java_collection_framework.bai_tap.optional_my_bst;

import java_collection_framework.thuc_hanh.cay_tim_kiem_nhi_phan.TreeNodeOptional;

import java.util.LinkedList;
import java.util.Queue;

public class MyBST<E extends Comparable<E>> {
    protected TreeNodeOptional<E> root;
    protected int size = 0;

    public MyBST() {
    }

    public MyBST(E value) {
        insert(value);
    }

    public void insert(E value) {
        if (root == null) {
            root = new TreeNodeOptional<>(value);
            size++;
        } else if (search(value)) { // Kiểm tra xem giá trị muốn thêm đã tồn tại hay chưa
            System.out.println("Invalid value ! Value already exist !");
        } else { // Chưa có thì thêm vào
            if (value.compareTo(browserForInsert(value).element) < 0) {
                browserForInsert(value).left = new TreeNodeOptional<>(value);
            } else if (value.compareTo(browserForInsert(value).element) > 0) {
                browserForInsert(value).right = new TreeNodeOptional<>(value);
            }
            size++;
        }
    }

    public TreeNodeOptional<E> browserForInsert(E value) {
        TreeNodeOptional<E> parent = null;
        TreeNodeOptional<E> current = root;
        while (current != null) { // Tìm nút có giá trị min hoặc max hiện tại
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
        if (root == null) System.out.println("BST is empty !");
        if (deleteNode(root, value) != null) {
            root = deleteNode(root, value);
            size--;
            System.out.println("Delete Complete !");
        } else System.out.println("Not found !");
    }

    public TreeNodeOptional<E> deleteNode(TreeNodeOptional<E> root, E value) {
        if (root == null) return null; // Không có phần tử muốn xóa !
        if (value.compareTo(root.element) < 0) { // Giá trị muốn xóa nhỏ hơn giá trị của nút hiện tại nên chuyển sang nhánh trái :
            root.left = deleteNode(root.left, value);
        } else if (value.compareTo(root.element) > 0) { // Giá trị muốn xóa lớn hơn giá trị của nút hiện tại nên chuyển sang nhánh phải :
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) return root.right; // Nút lá hoặc nút cha có 1 nút con bên phải
            else if (root.right == null) return root.left; // Nút lá hoặc nút cha có 1 nút con bên trái
            else { // Nút muốn xóa có 2 nút con thì thay giá trị của nút muốn xóa bằng giá trị của nút có giá trị nhỏ nhất trong nhánh bên phải
                TreeNodeOptional<E> temp = root.right;                                                                  //           của nút đó
                while (temp.left != null) {
                    temp = temp.left; // Tìm nút có giá trị nhỏ nhất
                }
                E minAtRight = temp.element;
                root.element = minAtRight; // Gán giá trị cho nút muốn xóa
                root.right = deleteNode(root.right, minAtRight); // Xóa nút có giá trị nhỏ nhất vừa tìm được
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
        if (root == null) return false; // Tìm không thấy !
        if (leftBrowser(value, root)) return searchMyBST(value, root.left);
        else if (rightBrowser(value, root)) return searchMyBST(value, root.right);
        else return true; // Tìm thấy !
    }

    public int getSize() {
        return size;
    }

    // Duyệt tiền thứ tự ( gốc -> trái -> phải ) :
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

    // Duyệt trung thứ tự ( trái -> gốc -> phải ) :
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

    // Duyệt hậu thứ tự ( trái -> phải -> gốc ) :
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

    // Duyệt theo tầng ( theo chiều rộng hay theo level ) :
    public void printLevelOrder(){
        printLevelOrder(root);
    }

    public void printLevelOrder(TreeNodeOptional<E> root) {
        if (root == null) return;
        Queue<TreeNodeOptional<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNodeOptional<E> current = queue.remove();
            System.out.print(current.element + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
