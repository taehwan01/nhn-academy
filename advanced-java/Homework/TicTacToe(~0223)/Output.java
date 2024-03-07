public class Output {
    // 게임 시작 출력
    public static void gameStart() {
        System.out.print(Constants.GAME_START);
    }

    // 각자 말 출력
    public static void playerHorse(char userPlayer, char computerPlayer) {
        System.out.println(Constants.USER_PLAYER + userPlayer + Constants.COMPUTER_PLAYER + computerPlayer + "\n");
    }

    // 게임 종료 출력
    public static void gameEnd() {
        System.out.println(Constants.GAME_END);
    }

    // 누가 먼저 시작하나 출력
    public static void whoIsNext(boolean isUserTurn) {
        if (isUserTurn) {
            System.out.print(Constants.USER_TURN);
        } else {
            System.out.println(Constants.COMPUTER_TURN);
        }
    }

    // 사용자 승리 출력
    public static void userWin() {
        System.out.println(Constants.WIN);
    }

    // 비김 출력
    public static void draw() {
        System.out.println(Constants.DRAW);
    }

    // 사용자 패배 출력
    public static void userLose() {
        System.out.println(Constants.LOSE);
    }

    // 사용자와 컴퓨터 턴을 입력 받아 보드 위에 출력
    public static void currentBoard(char[][] board) {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
                if (j != Constants.BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            if (i != Constants.BOARD_SIZE - 1) {
                System.out.println("\n---------");
            }
        }
        System.out.println();
        System.out.println();
    }
}
