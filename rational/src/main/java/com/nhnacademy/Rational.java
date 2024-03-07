package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * 유리수
 * 
 * @author m.
 */
public class Rational {
    // 분자
    private int numerator;
    // 분모
    private int denominator;
    static Logger logger = (Logger) LogManager.getLogger(Rational.class.getName());
    // 로그 매니저가 static이 아니더라도 로그의 이름이 같다면 같인 로거를 반환한다.
    // new로 생성하지 않는다. 각 객체별로 개별적으로 하려면 생성자에서 활용
    // 이 부분들은 생성자보다 먼저 실행되기 때문에 생성자에서 사용할 수 있다.

    /**
     * 기본 생성자
     * 
     * @param n 분자
     */
    public Rational(int n) {
        this.numerator = n;
        this.denominator = 1;
        logger.trace("new Rational: [{}/{}]", numerator, denominator);
    }

    /**
     * 분수의 분자와 분모를 받아서 생성
     * 
     * @param numerator   분자
     * @param denominator 분모
     * @throws ArithmeticException  분모가 0일 때
     * @throws OutOfBoundsException 오버플로우(분모가 Integer.MAX_VALUE를 넘을 경우)
     */
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        }

        long g = gcd(Math.abs((long) numerator), Math.abs((long) denominator));

        this.numerator = (int) (numerator / g);
        this.denominator = (int) (denominator / g);

        if (this.denominator < 0) {
            if ((this.numerator == Integer.MIN_VALUE) || (this.denominator == Integer.MIN_VALUE)) {
                throw new OutOfBoundsException();
            }

            this.numerator *= -1;
            this.denominator *= -1;
        }

        logger.trace("new Rational: [{}/{}]", numerator, denominator);
    }

    /**
     * 복사 생성자
     * 
     * @param other 복사할 Rational
     */
    public Rational(Rational other) {
        this.numerator = other.getNumerator();
        this.denominator = other.getDenominator();
        logger.trace("new Rational: [{}/{}]", numerator, denominator);
    }

    /**
     * 분자를 반환
     * 
     * @return 분자
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * 분모를 반환
     * 
     * @return 분모
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * 분수의 값을 [분자/분모] 형태로 반환
     * 
     * @return 분수의 값
     */
    @Override
    public String toString() {
        if (getDenominator() == 1) {
            return "[" + getNumerator() + "]";
        }
        return "[" + numerator + "/" + denominator + "]";
    }

    // 분수의 값 일치 확인
    @Override
    public boolean equals(Object other) {
        logger.trace("equals: {}", other);
        return (other instanceof Rational)
                && (getNumerator() == ((Rational) other).getNumerator())
                && (getDenominator() == ((Rational) other).getDenominator());
        // && (hashCode() == other.hashCode())
    }

    // 분수의 덧셈
    // public Rational add(Rational other) {} 이렇게 해도 됨
    public static Rational add(Rational a, Rational b) {
        int numerator = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
        int denominator = a.getDenominator() * b.getDenominator();

        return new Rational(numerator, denominator);
    }

    // 분수의 뺄셈
    public static Rational subtract(Rational a, Rational b) {
        int numerator = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();
        int denominator = a.getDenominator() * b.getDenominator();

        return new Rational(numerator, denominator);
    }

    // 분수의 곱셈
    public static Rational multiply(Rational a, Rational b) {
        int numerator = a.getNumerator() * b.getNumerator();
        int denominator = a.getDenominator() * b.getDenominator();

        logger.info("multiply: [{}/{}]", numerator, denominator);
        if (numerator == Integer.MAX_VALUE) {
            logger.error("multiply: [{}/{}]", numerator, denominator);
        }
        return new Rational(numerator, denominator);
    }

    // 분수의 나눗셈
    public static Rational divide(Rational a, Rational b) {
        return Rational.multiply(a, b.reciprocal());
    }

    public Rational inverse() {
        return new Rational(-getNumerator(), getDenominator());
    }

    public Rational reciprocal() {
        return new Rational(getDenominator(), getNumerator());
    }

    public Rational pow(int y) {
        return new Rational((int) Math.pow(getNumerator(), y), (int) Math.pow(getDenominator(), y));
    }

    // 최대공약수
    long gcd(long l, long m) {
        if (l < 0 || m < 0) {
            throw new ArithmeticException();
        }

        if (m == 0) {
            return l;
        }

        return gcd(m, l % m);
    }

    // 최소공배수
    long lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public Rational opposite() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'opposite'");
    }

}
