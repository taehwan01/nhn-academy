public class VariantParameters {
    static int max(int... values) {
        int max = Integer.MIN_VALUE;

        for (int value : values) {
            if (value > max)
                max = value;
        }

        return max;
    }

    public static void main(String[] args) {
        int maxNumber = max(9, 6, 0, 1, 5);
        System.out.println("maxNumber: " + maxNumber);
    }
}
