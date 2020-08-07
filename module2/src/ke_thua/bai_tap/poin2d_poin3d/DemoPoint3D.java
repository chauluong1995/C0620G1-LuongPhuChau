package ke_thua.bai_tap.poin2d_poin3d;

import java.util.Arrays;

public class DemoPoint3D {
    public static void main(String[] args) {
        Point3D point3D_1 = new Point3D();
        Point3D point3D_2 = new Point3D(5, 5, 5);

        System.out.println("point3D_2 : " + point3D_2);
        System.out.println("point3D_1 : " + point3D_1);

        point3D_1.setXYZ(10, 10, 10);
        System.out.println("point3D_1 : " + point3D_1);

        System.out.println("point3D_1 : " + Arrays.toString(point3D_1.getXYZ()));
    }
}
