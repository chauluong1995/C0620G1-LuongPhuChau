package abstract_class_interface.bai_tap.resizeable;

import ke_thua.thuc_hanh.Shape;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizeableCircle(1);
        shapes[1] = new ResizeableRectangle(5, 5);
        shapes[2] = new ResizeableSquare(10);

        System.out.println("Before change :");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println((i + 1) + " : " + shapes[i].getArea());
        }

        System.out.println("After change :");
        shapes[0].resize(Math.random() * 99 + 1);
        shapes[1].resize(Math.random() * 99 + 1);
        shapes[2].resize(Math.random() * 99 + 1);
        for (int i = 0; i < shapes.length; i++) {
            System.out.println((i + 1) + " : " + shapes[i].getArea());
        }
    }
}
