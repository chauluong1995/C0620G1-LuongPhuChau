package access_modifier_and_static.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        System.out.print("Fan of class : ");
        Circle circle = new Circle();
        System.out.print("color : " + circle.getColor());
        System.out.print(" , radius : " + circle.getRadius());
        System.out.println(" , area : " + circle.getArea());

        System.out.print("My fan : ");
        Circle myCircle = new Circle(5, "blue");
        myCircle.setColor("yellow");
        System.out.print("color : " + myCircle.getColor());
        System.out.print(" , radius : " + myCircle.getRadius());
        System.out.print(" , area : " + myCircle.getArea());
    }
}
