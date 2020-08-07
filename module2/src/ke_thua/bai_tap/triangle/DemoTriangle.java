package ke_thua.bai_tap.triangle;

public class DemoTriangle {
    public static void main(String[] args) {
        Triangle triangle_1 = new Triangle();
        Triangle triangle_2 = new Triangle(10, 10, 10, "yellow");

        System.out.println("Triangle_1 " + triangle_1.toString());
        System.out.println("Triangle_2 " + triangle_2.toString());
    }
}
