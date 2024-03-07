import java.util.Arrays;

public class Utilities {

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    public static int max(int... values) {
        int result = values[0];
        for (int i : values) {
            result = max(i, result);
        }
        return result;
    }

    static int maxNum = Integer.MIN_VALUE;

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static int swap2(int a, int b) {
        return a;
    }

    public static int maxRecursive(int... values) {
        if (values.length != 2) {
            int[] restValues = Arrays.copyOfRange(values, 1, values.length);
            maxRecursive(restValues);
        }
        return values[0] > values[1] ? values[0] : values[1];
    }

    public static int maxRecursive2(int index, int... values) {
        if (indxe == 1) {
            return values[0];
        } else {
            return max(values[index], maxRecursive2(index - 1, values));
        }
    }
}

class Test {
    public static void main(String[] args) {
        // int i = 5;
        // int j = 10;

        // System.out.printf("i: %d, j: %d\n", i, j);
        // Utilities.swap(i, j);
        // j = Utilities.swap2(i, i = j);
        // System.out.printf("i: %d, j: %d\n", i, j);
        int max = Utilities.maxRecursive(6, 9, 0, 5, 3);
        System.out.println("MAX: " + max);
    }
}