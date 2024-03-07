class Adder implements BinaryOp {
    public int apply(int a, int b) {
        return a + b;
    }

}

public class Algorithm {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int calc(BinaryOp binder, int a, int b) {
        return binder.apply(a, b);
    }

    public static String smth(StringOp binder, int age, String name) {
        return binder.intro(age, name);
    }
}

class Test {
    public static void main(String[] args) {
        BinaryOp adder = Algorithm::add;

        BinaryOp b = new BinaryOp() {
            public int apply(int a, int b) {
                System.out.println(a + b);
                return a + b;
            }
        };

        // BinaryOp bb = (a, c) -> a + c;

        StringOp so = (age, name) -> "Hello, " + name + " you are " + age + " years old";

        // System.out.println(Algorithm.smth(so, 26, "Monte"));
        System.out.println(adder.apply(2, 3));
    }
}