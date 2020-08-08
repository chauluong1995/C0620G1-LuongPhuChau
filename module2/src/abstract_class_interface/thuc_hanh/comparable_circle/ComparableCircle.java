package abstract_class_interface.thuc_hanh.comparable_circle;

import ke_thua.bai_tap.circle_cylinder.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    boolean filled;

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        this.setRadius(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color);
        this.filled = filled;
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}

