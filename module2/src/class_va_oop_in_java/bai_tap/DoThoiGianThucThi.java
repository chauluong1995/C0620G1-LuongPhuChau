package class_va_oop_in_java.bai_tap;

import java.util.Arrays;

public class DoThoiGianThucThi {
    public static void main(String[] args) {
        double[] mang = new double[100000];
        for (int i = 0; i < 100000; i++) {
            mang[i] = Math.random()*100000;
            // System.out.println(mang[i]);
            // break;
        }
        StopWatch demoStopWatch = new StopWatch();
        demoStopWatch.start();
        Arrays.sort(mang);
        demoStopWatch.end();
        System.out.println("Thời gian sắp xếp 100000 số là : " + demoStopWatch.getElapsedTime() + " milliseconds");
    }
}
