package class_va_oop_in_java.bai_tap;

// Lớp Phương trình bậc 2 :
public class QuadraticEquation {
    double numberA;
    double numberB;
    double numberC;
    double delta;
    double root1;
    double root2;

    public QuadraticEquation(){
        // this ( 0, 0, 0 );
        // this ( giá trị mặc định );
    }

    public QuadraticEquation(double numberA, double numberB, double numberC) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.numberC = numberC;
    }

    public double getterSoA() {
        return this.numberA;
    }

    public double getterSoB() {
        return this.numberB;
    }

    public double getterSoC() {
        return this.numberC;
    }

    public double getDiscriminant() {
        return this.delta = (this.numberB * this.numberB) - 4 * this.numberA * this.numberC;
    }

    public double getRoot1() {
        if (this.delta >= 0) {
            return this.root1 = (-this.numberB + Math.sqrt(this.delta)) / (2 * this.numberA);
        } else return this.root1 = 0;
    }

    public double getRoot2() {
        if (this.delta >= 0) {
            return this.root2 = (-this.numberB - Math.sqrt(this.delta)) / (2 * this.numberA);
        } else return this.root2 = 0;
    }
}