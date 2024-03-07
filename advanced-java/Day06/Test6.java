import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        Student2 s1 = new Student2(7, "G");
        Student2 s2 = new Student2(1, "A");
        Student2 s3 = new Student2(3, "C");
        Student2 s4 = new Student2(2, "B");
        Student2 s5 = new Student2(4, "D");
        Student2 s6 = new Student2(6, "F");
        Student2 s7 = new Student2(5, "E");
        // Student2[] students = { s1, s2, s3, s4, s5, s6, s7 };
        List<Student2> list = new ArrayList<Student2>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);

        for (Student2 student2 : list) {
            System.out.println(student2.getName());
        }

        Collections.sort(list); // Comparable<Student2>를 구현한 클래스의 객체들을 정렬할 때 사용

        for (Student2 student2 : list) {
            System.out.println(student2.getName());
        }

        // // 버블 정렬
        // for (int i = 0; i < students.length - 1; i++) {
        // for (int j = 0; j < students.length - 1 - i; j++) {
        // if (students[j].compareTo(students[j + 1]) > 0) {
        // // 내가 쟤보다 뒷(큰)번호야, 내가 뒤로 갈게.
        // Student2 temp = students[j];
        // students[j] = students[j + 1];
        // students[j + 1] = temp;
        // }
        // }
        // }

        // for (int i = 0; i < students.length; i++) {
        // System.out.println(students[i].getName());
        // }
    }
}
