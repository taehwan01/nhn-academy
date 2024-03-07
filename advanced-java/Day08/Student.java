import java.util.Comparator;

public class Student implements Comparable<Student> {
    private int studentNo;
    private String name;
    private String department;

    public Student(int studentNo, String name, String department) {
        this.studentNo = studentNo;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return studentNo + ", " + name + ", " + department;
    }

    @Override
    public int compareTo(Student other) {
        return this.studentNo - other.studentNo;
    }
}