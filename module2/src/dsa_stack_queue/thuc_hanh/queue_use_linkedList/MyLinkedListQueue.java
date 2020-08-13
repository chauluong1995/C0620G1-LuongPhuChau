package dsa_stack_queue.thuc_hanh.queue_use_linkedList;

public class MyLinkedListQueue {
    private NodePractice head;
    private NodePractice tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        NodePractice temp = new NodePractice(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public NodePractice dequeue() {
        if (this.head == null)
            return null;
        NodePractice temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }
}
