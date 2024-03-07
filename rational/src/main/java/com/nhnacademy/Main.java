package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
        try {
            Rational r1 = new Rational(5, 18);
            Rational r2 = new Rational(9, 14);
            Rational r3 = new Rational(3);
            Rational r4 = new Rational(3);
            Rational r5 = new Rational(3);

            Rational addRational = new Rational(58, 63);
            Rational subtractRational = new Rational(-23, 63);
            Rational multiplyRational = new Rational(5, 28);
            Rational divideRational = new Rational(35, 81);
            Rational inverseRational = new Rational(-5, 18);
            Rational reciprocalRational = new Rational(18, 5);

            if (!addRational.equals(Rational.add(r1, r2))) {
                System.out.println("분수의 덧셈 ❌");
            } else {
                System.out.println("분수의 덧셈 ✅");
            }

            if (!subtractRational.equals(Rational.subtract(r1, r2))) {
                System.out.println("분수의 뺄셈 ❌");
            } else {
                System.out.println("분수의 뺄셈 ✅");
            }

            if (!multiplyRational.equals(Rational.multiply(r1, r2))) {
                System.out.println("분수의 곱셈 ❌");
            } else {
                System.out.println("분수의 곱셈 ✅");
            }

            if (!divideRational.equals(Rational.divide(r1, r2))) {
                System.out.println("분수의 나눗셈 ❌");
            } else {
                System.out.println("분수의 나눗셈 ✅");
            }

            if (!inverseRational.equals(r1.inverse())) {
                System.out.println("분수의 역원 ❌");
            } else {
                System.out.println("분수의 역원 ✅");
            }

            if (!reciprocalRational.equals(r1.reciprocal())) {
                System.out.println("분수의 역수 ❌");
            } else {
                System.out.println("분수의 역수 ✅");
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
}