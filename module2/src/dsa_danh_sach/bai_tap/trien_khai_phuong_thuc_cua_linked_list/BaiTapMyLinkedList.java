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
        if (head == null) {
            head = tail = new Node(element);
        } else {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }
        numNodes++;
    }

    public void addLast(E element) {
        if (head == null) {
            head = tail = new Node(element);
        } else {
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
        }
        numNodes++;
    }

    public E remove(int index) {
        if (numNodes == 0 || index < 0 || index >= numNodes) {
            return null;
        } else if (numNodes == 1) {
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return (E) temp.data;
        } else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }

    public E removeFirst() {
        Node temp = head;
        head = head.next;
        numNodes--;
        return (E) temp.data;
    }

    public E removeLast() {
        Node current = head;
        for (int i = 0; i < numNodes - 2; i++) {
            current = current.next;
        }
        Node temp = tail;
        tail = current;
        tail.next = null;
        numNodes--;
        return (E) temp.data;
    }

    public boolean remove(Object element) {
        Node temp = head;
        boolean checkRemove = false;
        if ((temp.data).equals(element)) {
            removeFirst();
            checkRemove = true;
        }
        for (int i = 1; i < numNodes; i++) {
            temp = temp.next;
            if ((temp.data).equals(element)) {
                if (i == numNodes - 1) removeLast();
                else remove(i);
                checkRemove = true;
            }
        }
        return checkRemove;
    }

    public E get(int index) {
        if (index >= numNodes) {
            return (E) "Ivalid Index !";
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
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
