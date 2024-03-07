public class Constants {
    // 상수
    public static final char O = 'O';
    public static final char X = 'X';
    public static final char EMPTY = ' ';

    public static final String USER_PLAYER = "\n사용자: ";
    public static final String COMPUTER_PLAYER = ", 컴퓨터: ";

    public static final int BOARD_SIZE = 3;

    public static final String GAME_START = "TicTacToe 게임을 시작합니다.\n\n먼저 시작하시겠습니까? ( O / X ) ";
    public static final String GAME_END = "게임이 종료되었습니다.";
    public static final String USER_TURN = "사용자 턴 (x, y): ";
    public static final String COMPUTER_TURN = "컴퓨터 턴";
    public static final String WIN = "***** 사용자 승리 *****";
    public static final String DRAW = "+++++ DRAW +++++";
    public static final String LOSE = "----- 사용자 패배 -----";

    public static String ERROR_INVALID_FIRST_PLAY = "* 잘못된 입력입니다. O 또는 X로 다시 입력해주세요.";
    public static String ERROR_INVALID_COORDINATE = "* 잘못된 좌표입니다. 0과 2 사이로 다시 입력해주세요.";
    public static String ERROR_ALREADY_TAKEN = "* 이미 선택된 좌표입니다. 다른 좌표를 선택해주세요.";
}
