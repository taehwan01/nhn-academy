import java.util.Scanner;

public class Whatday {
    static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static String[] monthNames = { "January", "Feburary", "March", "April", "May", "June", "July", "August",
            "Sepetember", "October", "November", "December" };

    public static void main(String[] args) {
        System.out.print("Enter a digit between 1 and 365: ");
        Scanner sc = new Scanner(System.in);
        int dayNum = Integer.parseInt(sc.nextLine());
        int monthNum;

        // calculate Month Number and days in Month using if statement
        if (dayNum <= 31) { // January
            monthNum = 0;
        } else if (dayNum <= 59) { // February 31 + 28
            monthNum = 1;
            dayNum -= 31;
        } else if (dayNum <= 90) { // March 31 + 28 + 31
            monthNum = 2;
            dayNum -= 59;
        } else if (dayNum <= 120) { // April 31 + 28 + 31 + 30
            monthNum = 3;
            dayNum -= 90;
        } else if (dayNum <= 151) { // May 31 + 28 + 31 + 30 + 31
            monthNum = 4;
            dayNum -= 120;
        } else if (dayNum <= 181) { // June 31 + 28 + 31 + 30 + 31 + 30
            monthNum = 5;
            dayNum -= 151;
        } else if (dayNum <= 212) { // July 31 + 28 + 31 + 30 + 31 + 30 + 31
            monthNum = 6;
            dayNum -= 181;
        } else if (dayNum <= 243) { // August 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31
            monthNum = 7;
            dayNum -= 212;
        } else if (dayNum <= 273) { // September 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30
            monthNum = 8;
            dayNum -= 243;
        } else if (dayNum <= 304) { // October 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31
            monthNum = 9;
            dayNum -= 273;
        } else if (dayNum <= 334) { // November 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30
            monthNum = 10;
            dayNum -= 304;
        } else { // December
            monthNum = 11;
            dayNum -= 334;
        }

        String monthName = monthNames[monthNum];

        System.out.println(monthName + ", " + dayNum);
    }
}