import java.util.LinkedList;
import java.util.Queue;

enum Strategy {
    dfs,
    bfs,
    dijkstra
}

public class Miro {
    static int[][] board;
    static int n, m;
    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    static public void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            String message;
            if (findMiro(Strategy.dfs, TEST_CASES[i])) {
                message = "길을 찾았습니다.";
            } else {
                message = "길을 찾지 못했습니다.";
            }

            System.out.println(message);
        }
    }

    static public boolean findMiro(Strategy strategy, int[][] cboard) {
        boolean res = false;
        board = cboard;
        n = board.length;
        m = board[0].length;

        switch (strategy) {
            case Strategy.bfs:
                res = bfs();
                break;
            case Strategy.dfs:
                res = dfs();
                break;
            default:
                break;
        }

        return res;
    }

    static private Boolean bfs() {
        boolean ch[][] = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        ch[0][0] = true;

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- != 0) {
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (board[nx][ny] == 1 || ch[nx][ny])
                        continue;
                    q.add(new Pair(nx, ny));
                    ch[nx][ny] = true;
                }
            }
        }

        return ch[n - 1][m - 1];
    }

    static private boolean dfs() {
        boolean ch[][] = new boolean[n][m];
        recur(0, 0, ch);
        return ch[n - 1][m - 1];
    }

    static private void recur(int x, int y, boolean ch[][]) {
        ch[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (board[nx][ny] == 1 || ch[nx][ny])
                continue;
            recur(nx, ny, ch);
        }
    }

    static int[][][] TEST_CASES = {
            { // fail
                    { 0, 1, 1, 1, 1 },
                    { 0, 0, 0, 1, 1 },
                    { 1, 1, 0, 0, 1 },
                    { 1, 1, 1, 0, 0 },
                    { 1, 1, 1, 1, 1 }
            },
            { // find
                    { 0, 1, 1, 1, 1 },
                    { 0, 0, 0, 1, 1 },
                    { 1, 1, 0, 0, 1 },
                    { 1, 1, 1, 0, 0 },
                    { 1, 1, 1, 1, 0 }
            },
            { // fail
                    { 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 1 }
            },
            { // find
                    { 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 1, 0 },
                    { 0, 1, 1, 1, 0 },
                    { 1, 0, 0, 1, 0 },
                    { 0, 1, 1, 1, 0 }
            },
            { // fail
                    { 0, 0, 0, 0, 0 },
                    { 1, 0, 1, 1, 0 },
                    { 0, 1, 0, 1, 1 },
                    { 0, 1, 0, 0, 1 },
                    { 0, 0, 1, 1, 1 }
            }
    };
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
