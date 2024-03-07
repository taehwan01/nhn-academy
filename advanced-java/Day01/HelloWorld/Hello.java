import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        int i = 5, j = 10;
        Scanner sc = new Scanner(System.in);
        try {
            i = sc.nextInt();
            i = sc.nextInt();

            System.out.println(i / j);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
