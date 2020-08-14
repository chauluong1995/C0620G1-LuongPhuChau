package java_collection_framework.thuc_hanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {
    public static void main(String[] args) {
        StudentComp student = new StudentComp("Kien", 30);
        StudentComp student1 = new StudentComp("Nam", 26);
        StudentComp student2 = new StudentComp("Anh", 38);
        StudentComp student3 = new StudentComp("Tung", 38);

        List<StudentComp> lists = new ArrayList<>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);

        Collections.sort(lists);
        System.out.println("Sắp xếp theo tên :");
        for (StudentComp st : lists) {
            System.out.println(st.toString());
        }

        lists.sort(new Comparator<>() {
            @Override
            public int compare(StudentComp o1, StudentComp o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });

        System.out.println("Sắp xếp theo tuổi :");
        for (StudentComp st : lists) {
            System.out.println(st.toString());
        }
//        AgeComparator ageComparator = new AgeComparator();
//        Collections.sort(lists, ageComparator);
//        System.out.println("So sanh theo tuoi:");
//        for (StudentComp st : lists) {
//            System.out.println(st.toString());
//        }
    }
}

class StudentComp implements Comparable<StudentComp> {
    private String name;
    private Integer age;

    public StudentComp(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "StudentComp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(StudentComp student) {
        return this.getName().compareTo(student.getName());
    }
}

//class AgeComparator implements Comparator<StudentComp> {
////    @Override
////    public int compare(StudentComp o1, StudentComp o2) {
////        if (o1.getAge() > o2.getAge()) {
////            return 1;
////        } else if (o1.getAge() == o2.getAge()) {
////            return 0;
////        } else {
////            return -1;
////        }
////    }
////}