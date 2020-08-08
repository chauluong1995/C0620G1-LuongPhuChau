package abstract_class_interface.bai_tap.resizeable;

import ke_thua.thuc_hanh.Rectangle;

public class ResizeableRectangle extends Rectangle implements Resizeable {
    public ResizeableRectangle() {
    }

    public ResizeableRectangle(double width, double length) {
        super(width, length);
    }

    @Override
    public void resize(double person){
        this.setWidth(person * this.getWidth());
        this.setLength(person * this.getLength());
    }
}
