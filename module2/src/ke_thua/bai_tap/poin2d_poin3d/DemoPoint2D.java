package ke_thua.bai_tap.poin2d_poin3d;

import java.util.Arrays;

public class DemoPoint2D {
    public static void main(String[] args) {
        Point2D point2D_1 = new Point2D();
        Point2D point2D_2 = new Point2D(5, 5);

        System.out.println("point2D_2 : " + point2D_2.toString());
        System.out.println("point2D_1 : " + point2D_1.toString());

        point2D_1.setXY(10, 10);
        System.out.println("point2D_1 : " + point2D_1.toString());

        System.out.println("point2D_1 : " + Arrays.toString(point2D_1.getXY()));
    }
}
