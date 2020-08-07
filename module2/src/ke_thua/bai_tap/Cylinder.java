package ke_thua.bai_tap;

public class Cylinder extends Circle {
    double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        this.radius = radius;
        this.color = color;
        this.height = height;
    }

    public double getVolume() {
        return this.getArea() * height;
    }

    @Override
    public String toString() {
        return "color : " + this.color + " , radius : " + this.radius + " , bottom area : " + this.getArea() + " , volume : " + this.getVolume();
    }
}
