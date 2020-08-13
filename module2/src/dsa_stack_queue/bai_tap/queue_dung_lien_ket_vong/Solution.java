package dsa_stack_queue.bai_tap.queue_dung_lien_ket_vong;

public class Solution {
    static void enQueue(QueueExercise queueExercise, int value) {
        NodeExercise temp = new NodeExercise();
        temp.data = value;
        if (queueExercise.front == null) queueExercise.front = temp;
        else queueExercise.rear.link = temp;
        queueExercise.rear = temp;
        queueExercise.rear.link = queueExercise.front;
    }

    static Object deQueue(QueueExercise queueExercise) {
        if (queueExercise.front == null) {
            //System.out.print("Queue is empty ! ");
            return null;
        }
        Object value;
        if (queueExercise.front == queueExercise.rear) {
            value = queueExercise.front.data;
            queueExercise.front = null;
            queueExercise.rear = null;
        } else {
            NodeExercise temp = queueExercise.front;
            value = temp.data;
            queueExercise.front = queueExercise.front.link;
            queueExercise.rear.link = queueExercise.front;
        }
        return value;
    }

    static void displayQueue(QueueExercise queueExercise) {
        NodeExercise temp = queueExercise.front;
        System.out.print("Elements in Circular Queue are : ");
        while (temp.link != queueExercise.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }

    public static void main(String[] args) {
        QueueExercise queueExercise = new QueueExercise();
        System.out.print(deQueue(queueExercise));
        System.out.println();
        enQueue(queueExercise, 27);
        enQueue(queueExercise, 5);
        enQueue(queueExercise, 1995);
        displayQueue(queueExercise);
        System.out.println();

        System.out.print("Delete " + deQueue(queueExercise));
        System.out.println();
        displayQueue(queueExercise);
    }
}
