import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("INPUT 2 NUMBERS");

        try {
            String temp = sc.nextLine();
            int a = Integer.parseInt(temp);

            temp = sc.nextLine();
            int b = Integer.parseInt(temp);

            sc.close();

            int c = a / b;
            System.out.printf("%d / %d = %d\n", a, b, c);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 입력되었습니다.");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
