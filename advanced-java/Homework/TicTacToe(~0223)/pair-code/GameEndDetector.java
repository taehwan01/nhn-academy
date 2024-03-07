public class GameEndDetector {

    static boolean isGameEnd(int[][] board, int round) {
        return hasWinner(board) || round == 9;
    }

    static boolean hasWinner(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (hasWinningRow(board, i) || hasWinningColumn(board, i))
                return true;
        }

        return hasWinningDiagonal(board) || hasWinningReverseDiagonal(board);
    }

    static boolean hasWinningRow(int[][] board, int i) {
        return board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i];
    }

    static boolean hasWinningColumn(int[][] board, int i) {
        return board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2];
    }

    static boolean hasWinningDiagonal(int[][] board) {
        return board[1][1] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2];
    }

    static boolean hasWinningReverseDiagonal(int[][] board) {
        return board[1][1] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

}
