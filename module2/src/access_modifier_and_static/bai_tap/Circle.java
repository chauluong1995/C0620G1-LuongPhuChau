package access_modifier_and_static.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle() {
    }

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

//    public void setRadius(double radius) {
//        this.radius = radius;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    double getRadius() {
        return radius;
    }

    protected double getArea() {
        return (radius * radius * Math.PI);
    }
}
