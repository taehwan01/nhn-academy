import java.util.Scanner;

public class WhatdayFor {
    static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static String[] monthNames = { "January", "Feburary", "March", "April", "May", "June", "July", "August",
            "Sepetember", "October", "November", "December" };

    public static void main(String[] args) {
        System.out.print("Enter a digit between 1 and 365: ");
        Scanner sc = new Scanner(System.in);
        int dayNum = Integer.parseInt(sc.nextLine());
        int monthNum = 0;

        for (int days : daysInMonth) {
            if (dayNum <= days) {
                break;
            } else {
                dayNum -= days;
                monthNum++;
            }
        }

        String monthName = monthNames[monthNum];

        System.out.println(monthName + ", " + dayNum);
    }
}