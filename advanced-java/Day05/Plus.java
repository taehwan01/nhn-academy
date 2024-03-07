class Rational {
    int nominator;
    int denominator;

    public Rational plus(Rational rational) {
    }

    public Rational multiply(Rational rational) {
    }
}

public class Plus {
    public static void main(String[] args) {
        int[] left = { 12, 21 };
        int[] right = { 5, 6 };
        int[] result = plusRational(left, right);
        System.out.println(result[0] + " / " + result[1]);
    }

    public static int[] plusRational(Rational left, Rational right) {
        return left.plus(right);
    }

    public static int gCD(int leftDenominator, int rightDenominator) {
        if (rightDenominator == 0) {
            return leftDenominator;
        } else {
            return gCD(rightDenominator, leftDenominator % rightDenominator);
        }
    }
}
