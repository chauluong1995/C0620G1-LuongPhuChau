package abstract_class_interface.bai_tap.resizeable;

import ke_thua.thuc_hanh.Circle;

public class ResizeableCircle extends Circle implements Resizeable {
    public ResizeableCircle() {
    }

    public ResizeableCircle(double radius) {
        this.setRadius(radius);
    }

    @Override
    public void resize(double person) {
        this.setRadius(person * this.getRadius());
    }
}
