public class Student extends Member {
    private String department;
    private int point;

    public Student(int no, String name, String department) {
        super(no, name); // 상속된 생성자
        this.department = department;
        this.point = 0;
    }

    public Student setDepartment(String department) {
        this.department = department;
        return this;
    }

    public Student setPoint(int point) {
        this.point = point;
        return this;
    }
}

class Test2 {
    public static void main(String[] args) {
        Student st = new Student(1010, "Monte", "SE").setDepartment("CG").setPoint(90);
    }
}