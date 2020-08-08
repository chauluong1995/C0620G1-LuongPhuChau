package class_va_oop_in_java.bai_tap.fan;

public class DemoFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3,true,10,"yellow");
        Fan fan2 = new Fan(2,false,5,"blue");
        Fan fan_3 = new Fan();
        System.out.println("Fan 1 : " + fan1);
        System.out.println("Fan 2 : " + fan2);
        System.out.println("Fan 3 : " + fan_3);
        fan_3.setOn(true);
        fan_3.setSpeed(fan_3.getFAST());
        System.out.println("Fan 3 : " + fan_3);
    }
}
