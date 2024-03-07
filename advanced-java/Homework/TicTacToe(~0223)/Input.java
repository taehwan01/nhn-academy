import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    // 사용자 먼저 시작할지 컴퓨터 먼저 시작할지 입력 받기
    public static char firstPlayer() {
        char firstPlay;

        try {
            firstPlay = scanner.next().charAt(0);
            if (firstPlay != Constants.O && firstPlay != Constants.X) {
                Error.invalidFirstPlay();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return firstPlayer(); // 단순 재귀 메소드가 아닌, 현재 메소드를 종료하면서 재귀 호출
        }

        return firstPlay;
    }

    // 사용자 입력 받기
    public static int[] userTurn() {
        int[] input = new int[2];
        try {
            if (!scanner.hasNextInt()) { // 정수 외의 값에도 에러
                scanner.next(); // 잘못된 입력 받기
                Error.invalidCoordinate();
            }
            input[0] = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                scanner.next();
                Error.invalidCoordinate();
            }
            input[1] = scanner.nextInt();

            // 0과 2 이외의 값에도 에러
            if (input[0] >= Constants.BOARD_SIZE || input[0] < 0 || input[1] >= Constants.BOARD_SIZE
                    || input[1] < 0) {
                Error.invalidCoordinate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scanner.nextLine(); // 잘못된 입력 받기
            return userTurn();
        }
        return input;
    }

}
