package ke_thua.bai_tap.point_movablepoint;

import java.util.Arrays;

public class DemoMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint_1 = new MovablePoint();
        MovablePoint movablePoint_2 = new MovablePoint(5, 5);
        MovablePoint movablePoint_3 = new MovablePoint(5, 5,10,10);

        System.out.println("movablePoint_1 : " + movablePoint_1.toString());
        System.out.println("movablePoint_2 : " + movablePoint_2.toString());
        System.out.println("movablePoint_3 : " + movablePoint_3.toString());

        movablePoint_1.setXY(10, 10);
        System.out.println("movablePoint_1 : " + movablePoint_1.toString());

        movablePoint_3.setSpeed(95, 95);
        System.out.println("movablePoint_3 : " + movablePoint_3.toString());

        System.out.println("movablePoint_3 : " + Arrays.toString(movablePoint_3.getSpeed()));

        System.out.println("movablePoint_3 : " + movablePoint_3.move());
    }
}
