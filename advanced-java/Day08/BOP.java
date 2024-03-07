@FunctionalInterface
interface BOP {
    int apply(int x, int y);
    // String any(String hello);
}

class Algorithm {
    public static int calc(BOP op, int x, int y) {
        return op.apply(x, y);
    }
}

class Test2 {
    public static void main(String[] args) {
        Algorithm.calc((x, y) -> {
            System.out.println(x + y);
            return (x + y) * 2;
        }, 3, 8);
    }
}