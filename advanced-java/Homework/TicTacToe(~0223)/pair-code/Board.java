public class Board {
    static int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

    static void placeMark(int x, int y, int symbol) {
        board[x][y] = symbol;
    }

    static boolean isValidMark(int x, int y) {
        return 0 <= x && x < 3 && 0 <= y && y < 3 && board[x][y] == 0;
    }
}
