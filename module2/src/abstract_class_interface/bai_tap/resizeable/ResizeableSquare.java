package abstract_class_interface.bai_tap.resizeable;

import ke_thua.thuc_hanh.Square;

public class ResizeableSquare extends Square implements Resizeable {
    public ResizeableSquare() {
    }

    public ResizeableSquare(double side) {
        super(side);
    }

    @Override
    public void resize(double person) {
        this.setSide(person * this.getSide());
    }
}
