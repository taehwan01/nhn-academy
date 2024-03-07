import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int round = 0; round <= 9; round++) {
            if (GameEndDetector.isGameEnd(Board.board, round)) {
                Output.printGameEndMessage(round);
                break;
            }

            Output.printGameStartMessage(round);

            if (round % 2 == 0) {
                Player.personTurn(scanner);
            } else {
                Player.computerTurn();
            }

            Output.printBoard(Board.board);
        }

        scanner.close();
    }
}
