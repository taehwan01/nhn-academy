public class Board {

    private char[][] board;

    Board() {
        board = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                board[i][j] = Constants.EMPTY;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void checkBoardEmpty(int x, int y) {
        if (board[x][y] != Constants.EMPTY) {
            Error.alreadyTaken();
        }
    }

    // 사용자 입력 값을 받아 보드 없데이트, player는 'O' 또는 'X'
    public void updateBoard(int x, int y, char player) {
        checkBoardEmpty(x, y);
        board[x][y] = player;
    }

    // 승패 확인
    public boolean isWin(char player) {
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        boolean row = true;
        boolean column = true;

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            // 대각선 확인
            if (board[i][i] != player) {
                diagonal1 = false;
            }
            if (board[i][Constants.BOARD_SIZE - 1 - i] != player) {
                diagonal2 = false;
            }

            // 가로, 세로 확인
            row = true;
            column = true;
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (board[i][j] != player) {
                    row = false;
                }
                if (board[j][i] != player) {
                    column = false;
                }
            }
            if (row || column) {
                return true;
            }
        }
        return diagonal1 || diagonal2;
    }

    public boolean isFull() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (board[i][j] == Constants.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
