package class_va_oop_in_java.bai_tap;

public class DoThoiGianThucThi {
    public static void main(String[] args) {
        double[] mang = new double[100000];
        for (int i=0;i<100000;i++){
            mang[i] = (Math.random()*99999) + 1;
        }

    }
}
