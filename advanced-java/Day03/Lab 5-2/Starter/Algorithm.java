public class Algorithm {
    static final int addFrom1To10 = 55;

    static int sigma(int start, int end, int step) {
        int sum = 0;
        for (int i = start; i <= end; i += step) {
            sum += i;
        }
        return sum;
    }

    static int pi(int start, int end, int step) {
        int mul = 1;
        for (int i = start; i <= end; i += step) {
            mul *= i;
        }
        return mul;
    }

    static int accumulate(Adder binder, int init, int start, int end, int step) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = binder.apply(result, i);
        }
        return result;
    }

    static int accumulate(Multiplier binder, int init, int start, int end, int step) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = binder.apply(result, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sigma(1, 100, 1));
        System.out.println(pi(1, 10, 1));

        Adder adder = new Adder();
        Multiplier multiplier = new Multiplier();
        System.out.println(accumulate(adder, 0, 1, 100, 1));
        System.out.println(accumulate(multiplier, 1, 1, 10, 1));
    }
}