public class Output {
    final static String[] SYMBOLS = { " ", "O", "X" };

    static void printGameStartMessage(int round) {
        if (round % 2 == 0) {
            System.out.printf("사용자 턴 (x y): ");
        } else {
            System.out.println("컴퓨터턴");
        }

    }

    static void printGameEndMessage(int round) {
        String message = "";

        if (round == 9)
            message = "무승부입니다.";
        else if (round % 2 == 1)
            message = "사용자가 이겼습니다.";
        else
            message = "컴퓨터가 이겼습니다.";

        System.out.println(message);
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(" %s ", SYMBOLS[board[i][j]]);
                if (j != 2)
                    System.out.printf("|");
            }
            System.out.println("\n---|---|---");
        }
        System.out.println();
    }

}
