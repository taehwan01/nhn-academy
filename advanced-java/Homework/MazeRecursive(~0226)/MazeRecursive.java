public class MazeRecursive {
    static final int PATH = 0;
    static final int WALL = 1;
    static final int VISITED = -1;
    static final int WAY_OUT = 2;

    static final int[][] maze = {
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
        int startX = 0, startY = 0;
        printMaze();
        findPath(startX, startY);
        printMaze();

        if (maze[N - 1][M - 1] == WAY_OUT) {
            System.out.println("* 탈출에 성공했습니다.");
        } else {
            System.out.println("* 탈출할 수 없는 미로입니다.");
        }
    }

    static boolean findPath(int x, int y) {
        // 범위를 벗어나면 탐색 그만
        if (x < 0 || y < 0 || x > N - 1 || y > M - 1) {
            return false;
        }

        // 길이 아니어도 탐색 그만
        if (maze[x][y] != PATH) {
            return false;
        }

        // 종료되지 않고 탐색된 길은 2(WAY_OUT)로 변환
        maze[x][y] = WAY_OUT;

        // 종료 지점에 도달했을 경우 종료
        if (x == N - 1 && y == M - 1) {
            return true;
        }

        if (findPath(x - 1, y) || findPath(x, y - 1) || findPath(x + 1, y) || findPath(x, y + 1)) {
            // 다시 사방으로 탐색 시작해서 한 곳이라도 길이 있으면 그 쪽으로 탐색
            return true;
        }
        // 길이 막혔다면 -1(VISITED)로 변환
        maze[x][y] = VISITED;
        return false;

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
