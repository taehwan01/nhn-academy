
class PrintToStandardOutput implements Function {
    public void print(String name) {
        System.out.println(name);
    }
}

public class Test {
    public static void main(String[] args) {
        Student s = new Student(1, "TaeHwan", "SE");

        // Function f = x -> System.out.println(x);

        // PrintToStandardOutput p = new PrintToStandardOutput();
        // s.printName(x -> System.out.println("Hello, " + x));
        s.printName(System.out::println);
    }
}