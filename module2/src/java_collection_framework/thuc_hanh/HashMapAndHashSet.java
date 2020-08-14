package java_collection_framework.thuc_hanh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapAndHashSet {
    public static void main(String[] args) {
        StudentHash student1 = new StudentHash("Nam",20, "HN");
        StudentHash student2 = new StudentHash("Hung",21, "HN");
        StudentHash student3 = new StudentHash("Ha",22, "HN");

        Map<Integer, StudentHash> studentMap = new HashMap<>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);

        for(Map.Entry<Integer, StudentHash> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<StudentHash> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);

        for(StudentHash student : students){
            System.out.println(student.toString());
        }
    }
}
class StudentHash {
    private String name;
    private int age;
    private String address;

    public StudentHash(String name, int age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student name=" + name + ",age=" + age + ",address=" + address;
    }
}
