public class Rational {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        int g = this.gCD(numerator, denominator);

        this.numerator /= g;
        this.denominator /= g;
    }

    public static Rational plus(Rational left, Rational right) {
        int numerator = left.numerator * right.denominator + right.numerator * left.denominator;
        int denominator = left.denominator * right.denominator;

        return new Rational(numerator, denominator);
    }

    public static int gCD(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gCD(n, m % n);
        }
    }

    public static void main(String[] args) {
        Rational i = new Rational(1, 4);
        Rational j = new Rational(3, 8);
        Rational result = Rational.plus(i, j);

        System.out.println(result.numerator + "/" + result.denominator);
    }
}
