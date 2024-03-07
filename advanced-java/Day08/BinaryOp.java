@FunctionalInterface
interface BinaryOp {
    int apply(int a, int b);
}

class Algo {
    public static int calc(BinaryOp op, int a, int b) {
        return op.apply(a, b);
    }
}

// class Adder implements BinaryOp {
// public int apply(int a, int b) {
// return a + b;
// }
// }

// class Multiplier implements BinaryOp {
// public int apply(int a, int b) {
// return a * b;
// }
// }

class Test {
    public static void main(String[] args) {
        BinaryOp adder = (x, y) -> x + y;
        BinaryOp multiplier = (x, y) -> x * y;
        System.out.println(Algo.calc((x, y) -> x + y, 3, 4));
    }
}
