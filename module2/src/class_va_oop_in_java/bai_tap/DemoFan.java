package class_va_oop_in_java.bai_tap;

public class DemoFan {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Fan fan1 = new Fan(3,true,10,"yellow");
        Fan fan2 = new Fan(2,false,5,"blue");
        System.out.println("Fan 1 : " + fan1.toString());
        System.out.println("Fan 2 : " + fan2.toString());
        System.out.println("Fan 3 : " + fan.toString());
        fan.setOn(true);
        fan.setSpeed(fan.getFAST());
        System.out.println("Fan 3 : " + fan.toString());
    }
}
