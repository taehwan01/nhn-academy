import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        String name;

        System.out.print("이름을 입력해주세요: ");

        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        System.out.printf("%s 님, 어서오세요.\n", name);
    }
}