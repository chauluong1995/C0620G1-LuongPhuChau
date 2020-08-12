package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linked_list;

public class BaiTapMyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public BaiTapMyLinkedList(E element) {
        head = new Node(element);
    }

    static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= numNodes) {
            addLast(element);
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
            numNodes++;
        }
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        if (tail == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }
}
