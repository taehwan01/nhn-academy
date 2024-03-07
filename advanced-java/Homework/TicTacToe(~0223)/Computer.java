public class Computer {
    public static int[] computerTurn(Board board) {
        int[] computerInput = new int[2];
        while (true) {
            int x = (int) (Math.random() * Constants.BOARD_SIZE);
            int y = (int) (Math.random() * Constants.BOARD_SIZE);

            // 무작위 숫자가 빈 공간을 가리킬 때까지 반복
            if (board.getBoard()[x][y] == Constants.EMPTY) {
                computerInput[0] = x;
                computerInput[1] = y;
                return computerInput;
            }
        }
    }
}