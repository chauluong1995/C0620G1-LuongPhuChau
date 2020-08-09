package abstract_class_interface.bai_tap.resizeable;

import abstract_class_interface.bai_tap.colorable.Colorable;
import ke_thua.thuc_hanh.Square;

public class ResizeableSquare extends Square implements Resizeable, Colorable {
    public ResizeableSquare() {
    }

    public ResizeableSquare(double side) {
        super(side);
    }

    @Override
    public void resize(double person) {
        this.setSide(person * this.getSide());
    }

    @Override
    public void howToColor(){
        System.out.println("Color all four sides.");
    }
}
