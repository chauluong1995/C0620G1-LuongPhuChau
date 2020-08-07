package ke_thua.bai_tap;

public class DemoCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle(5,"red");
        Cylinder cylinder = new Cylinder(10,"yellow",10);
        System.out.println("Circle : " + circle.toString());
        System.out.println("Cylinder : " + cylinder.toString());
    }
}
