package string_regex.bai_tap.validate_class_name;

public class TestClassName {
    public static final String[] validClassName = new String[]{"C0620G", "C0318G"};
    public static final String[] invalidClassName = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        ClassNameExample classNameExample = new ClassNameExample();
        for (String name : validClassName) {
            boolean isvalid = classNameExample.validate(name);
            System.out.println("Class Name is " + name + " is valid " + isvalid);
        }

        System.out.println();

        for (String name : invalidClassName) {
            boolean isvalid = classNameExample.validate(name);
            System.out.println("Class Name is " + name + " is valid " + isvalid);
        }
    }
}
