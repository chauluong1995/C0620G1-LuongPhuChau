package ke_thua.bai_tap.circle_cylinder;

public class DemoCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle(5,"red");
        Cylinder cylinder = new Cylinder(10,10,"yellow");
        System.out.println("Circle : " + circle);
        System.out.println(cylinder);
    }
}
