package ke_thua.bai_tap.triangle;

import ke_thua.thuc_hanh.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side3;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return (this.side1 + this.side2 + this.side3);
    }

    public String getArea() {
        double halfPerimeter = (this.side1 + this.side2 + this.side3) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - this.side1) * (halfPerimeter - this.side2) * (halfPerimeter - this.side3));
        return " Area : " + area;
    }

    @Override
    public String toString() {
        return "has 3 side : " + this.side1 + " , " + this.side2 + " and " + this.side3
                + " . Perimeter : " + this.getPerimeter() + " ." + this.getArea() + " . Color : " + this.getColor();
    }
}
