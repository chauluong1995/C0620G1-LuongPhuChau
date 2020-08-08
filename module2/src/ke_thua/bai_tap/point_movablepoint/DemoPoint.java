package ke_thua.bai_tap.point_movablepoint;

import java.util.Arrays;

public class DemoPoint {
    public static void main(String[] args) {
        Point point_1 = new Point();
        Point point_2 = new Point(5, 5);

        System.out.println("point_2 : " + point_2);
        System.out.println("point_1 : " + point_1);

        point_1.setXY(10, 10);
        System.out.println("point_1 : " + point_1);

        System.out.println("point_1 : " + Arrays.toString(point_1.getXY()));
    }
}
