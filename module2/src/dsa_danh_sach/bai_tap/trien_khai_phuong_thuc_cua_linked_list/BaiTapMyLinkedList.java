package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linked_list;

public class BaiTapMyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public BaiTapMyLinkedList() {
    }

    public BaiTapMyLinkedList(E element) {
        head = new Node(element);
        tail = head;
        numNodes++;
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

    public void add(E element, int index) {
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
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        tail.next = newNode;
        tail = newNode;
        numNodes++;
    }

    public E remove(int index) {
        if (numNodes == 0 || index < 0 || index > numNodes) {
            return null;
        } else {
            Node temp = head;
            if (index == 0) {
                head = head.next;
                numNodes--;
                return (E) temp.data;
            } else {
                for (int i = 0; i < index - 2; i++) {
                    temp = temp.next;
                }
                Node current = temp.next;
                temp.next = current.next;
                numNodes--;
                return (E) current.data;
            }
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
