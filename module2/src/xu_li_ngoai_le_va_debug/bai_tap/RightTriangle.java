package xu_li_ngoai_le_va_debug.bai_tap;

public class RightTriangle {

    public RightTriangle(int side1, int side2, int side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            throw new IllegalTriangleException("Tam giác không hợp lệ !");
        else throw new IllegalTriangleException("Tam giác hợp lệ !");
    }
}
