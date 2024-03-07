import java.util.Scanner;

public class Whatday {
    static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static int[] daysInLeapMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static String[] monthNames = { "January", "Feburary", "March", "April", "May", "June", "July", "August",
            "Sepetember", "October", "November", "December" };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter year number: ");

            // String line = scanner.nextLine();
            int yearNum = scanner.nextInt();
            scanner.nextLine();

            boolean isLeapYear = (yearNum % 4 == 0) &&
                    (yearNum % 100 != 0 || yearNum % 400 == 0);

            if (isLeapYear) {
                System.out.println("it's Leap Year");
            } else {
                System.out.println("it's Common Year");
            }
            int maxDayNum = isLeapYear ? 366 : 365;

            System.out.print("Enter a day Number between 1 and " + maxDayNum + ": ");
            String line = scanner.nextLine();
            int dayNum = Integer.parseInt(line);
            if (dayNum < 1 || dayNum > maxDayNum) {
                throw new IllegalArgumentException("Out of date range");
            }

            int monthNum = 0;

            for (int days : isLeapYear ? daysInLeapMonth : daysInMonth) {
                if (dayNum <= days) {
                    break;
                } else {
                    dayNum -= days;
                    monthNum++;
                }
            }

            String monthName = monthNames[monthNum];

            System.out.printf("%s, %d \n", monthName, dayNum);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}