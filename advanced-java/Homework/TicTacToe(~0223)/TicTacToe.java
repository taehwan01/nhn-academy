public class TicTacToe {
    static Board board;
    static char currentPlayer;
    static boolean isUserTurn;
    static boolean winner;

    // 말 고르기 (먼저 하는 사람이 'O')
    static char userPlayer;
    static char computerPlayer;

    public static void main(String[] args) {
        startGame();
        gameProcess();
        endGame();
    }

    // 게임 시작 및 보드 초기화
    static void startGame() {
        Output.gameStart();

        // 새 보드로 시작
        board = new Board();

        // 사용자 먼저 시작 여부 결정
        currentPlayer = Input.firstPlayer();

        // 사용자 턴인지 확인
        isUserTurn = (currentPlayer == Constants.O);
        if (isUserTurn) {
            userPlayer = Constants.O;
            computerPlayer = Constants.X;
        } else {
            userPlayer = Constants.X;
            computerPlayer = Constants.O;
        }
        Output.playerHorse(userPlayer, computerPlayer);

        // 현재 승자 없음
        winner = false;
    }

    // 승자가 나올 때까지 게임 진행
    static void gameProcess() {
        while (!winner && !board.isFull()) {
            currentPlayer = isUserTurn ? userPlayer : computerPlayer;
            Output.whoIsNext(isUserTurn);

            if (isUserTurn) { // 사용자 차례
                int[] userInput = Input.userTurn();
                try {
                    board.updateBoard(userInput[0], userInput[1], currentPlayer);
                    isUserTurn = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    isUserTurn = true; // 다시 while문으로 돌아가서 사용자 차례로
                }
            } else { // 컴퓨터 차례
                int[] computerInput = Computer.computerTurn(board);
                board.updateBoard(computerInput[0], computerInput[1], currentPlayer);
                isUserTurn = true;
            }

            // 현재 보드 상태 출력
            Output.currentBoard(board.getBoard());

            // 승자 여부만 체크, 누가 승자인지는 게임 종료 시 판별
            winner = board.isWin(currentPlayer);
        }
    }

    // 승자 판별
    static void endGame() {
        if (winner) {
            // 승자가 있는데
            if (isUserTurn) { // 현재 사용자 차례이면 사용자 패배
                Output.userLose();
            } else { // 현재 컴퓨터 차례이면 사용자 승리
                Output.userWin();
            }
        } else { // 승자 없는데 끝났으면 비긴
            Output.draw();
        }

        Output.gameEnd();
    }
}