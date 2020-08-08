package ke_thua.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBottomArea() {
        return super.getArea();
    }

    public double getAroundArea() {
        return this.height * 2 * Math.PI * this.getRadius();
    }

    public double getTotalArea() {
        return this.getAroundArea() + this.getArea() * 2;
    }

    public double getVolume() {
        return this.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder has : " + this.getRadius() + " , color : " + this.getColor() + " , bottom area : " + this.getBottomArea() +
                " , around area : " + this.getAroundArea() + " , total area : " + this.getTotalArea() + " , volume : " + this.getVolume();
    }
}
