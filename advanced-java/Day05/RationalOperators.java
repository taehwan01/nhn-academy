
public class RationalOperators {
    public static int[] plus(int[] left, int[] right) {
        int[] result = new int[2];
        result[0] = left[0] * right[1] + right[0] * left[1];
        result[1] = left[1] * right[1];
        return result;
    }

    public static int[] multiply(int[] left, int[] right) {
        int[] result = new int[2];
        result[0] = left[0] * right[0];
        result[1] = left[1] * right[1];
        return result;
    }

    public static int[] divide(int[] left, int[] right) {
        int[] result = multiply(left, right);
        int gCD = gCD(result[0], result[1]);
        result[0] /= gCD;
        result[1] /= gCD;
        return result;
    }

    public static int gCD(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gCD(n, m % n);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] i = { 2, 4 };
        int[] j = { 3, 8 };
        int[] result = RationalOperators.plus(i, j);

        System.out.println(result[0] + "/" + result[1]);
    }
}