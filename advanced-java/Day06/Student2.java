public class Student2 implements Comparable<Student2> {
    private int studentNo;
    private String name;

    public Student2(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }

    public int getStudentNo() {
        return this.studentNo;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student2 student) {
        return this.studentNo - student.studentNo;
        // if (this.studentNo < student.studentNo)
        // return -1;
        // else if (this.studentNo == student.studentNo)
        // return 0;
        // else
        // return 1;
    }

}
