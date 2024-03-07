
public class Maze {
    static final int VOID = 0;
    static final int WALL = 1;
    static final int MOVED = 2;
    static final int VISITED = 4;
    static final int MIN_MAZE_LENGTH = 2;
    static final int MAX_MAZE_LENGTH = 5;

    private int[][] board;
    private int n, m;

    public static void main(String[] args) {
        new Maze();
    }

    Maze() {
        this(RandomNumberGenerator.get(MIN_MAZE_LENGTH, MAX_MAZE_LENGTH),
                RandomNumberGenerator.get(MIN_MAZE_LENGTH, MAX_MAZE_LENGTH));
    }

    Maze(int n, int m) {
        this(generateBoard(n, m));
    }

    Maze(int[][] board) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;

        System.out.println("미로가 생성되었습니다.");
        this.print();
    }

    void mark(int x, int y) {
        this.board[x][y] = MOVED;
    }

    void remove(int x, int y) {
        this.board[x][y] = VISITED;
    }

    boolean isArrive(int x, int y) {
        return x == n - 1 && y == m - 1;
    }

    boolean canNotMove(int x, int y) {
        return isOver(x, y) || board[x][y] != VOID;
    }

    void print() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                System.out.printf("%d ", this.board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isOver(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private static int[][] generateBoard(int n, int m) {
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (RandomNumberGenerator.get(1, 10) < 2) {
                    board[i][j] = WALL;
                } else {
                    board[i][j] = VOID;
                }
            }
        }
        board[0][0] = VOID;

        return board;
    }

}
