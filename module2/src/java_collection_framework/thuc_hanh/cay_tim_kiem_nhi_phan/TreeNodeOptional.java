package java_collection_framework.thuc_hanh.cay_tim_kiem_nhi_phan;

public class TreeNodeOptional<E> {
    public E element;
    public TreeNodeOptional<E> left;
    public TreeNodeOptional<E> right;

    public TreeNodeOptional(E e) {
        element = e;
    }
}
