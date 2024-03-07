import java.util.Stack;

public class MazeStack {
    static int[][] maze = {
            { 0, 0, 0, 0, 0, 0, 0, 1 },
            { 0, 1, 1, 0, 1, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 0, 0, 1, 1, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 1, 1 },
            { 0, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 1, 1, 1, 0, 1, 0, 0 },
    };
    static int N = maze.length;
    static int M = maze[0].length;

    public static void main(String[] args) {
        // maze 출력
        printMaze();
        findPath();
        printMaze();

        if (maze[N - 1][M - 1] == 2) {
            System.out.println("* 탈출에 성공했습니다.");
        } else {
            System.out.println("* 탈출할 수 없는 미로입니다.");
        }
    }

    static void findPath() {
        Stack<Coordinate> stack = new Stack<Coordinate>();
        int X = 0, Y = 0;
        // 길이 있는 한 계속 maze[i][j] push 하고, 길이 막히면 -1로 변환하면서 스택에서 빠져나온다.

        stack.push(new Coordinate(X, Y));
        while (X != N - 1 || Y != M - 1) {
            maze[X][Y] = 2;
            if (moveTo(X - 1, Y)) {
                stack.push(new Coordinate(--X, Y));
            } else if (moveTo(X, Y - 1)) {
                stack.push(new Coordinate(X, --Y));
            } else if (moveTo(X + 1, Y)) {
                stack.push(new Coordinate(++X, Y));
            } else if (moveTo(X, Y + 1)) {
                stack.push(new Coordinate(X, ++Y));
            } else {
                // 길이 막혔다면 스택에서 이동 가능할 때까지(다시 반복문) 후진
                stack.pop();
                maze[X][Y] = -1;
                if (!stack.isEmpty()) {
                    X = stack.peek().getX();
                    Y = stack.peek().getY();
                } else {
                    // 탈출할 수 없다면 종료
                    break;
                }
            }

            // 마지막 탈출구도 2로 전환
            if (X == N - 1 && Y == M - 1) {
                maze[X][Y] = 2;
            }
        }
    }

    static boolean moveTo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && maze[x][y] == 0;
    }

    static void printMaze() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}