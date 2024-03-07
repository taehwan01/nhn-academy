public class Maze {
    final static int[][][] MAZES = { {
            { 0, 1, 0, 1, 0, 1 },
            { 0, 1, 1, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0, 1 },
            { 0, 1, 0, 0, 0, 0 },
    } // 10
            , {
                    { 0, 1, 0, 1, 0, 1 },
                    { 0, 1, 1, 1, 0, 1 },
                    { 0, 0, 0, 1, 0, 1 },
                    { 0, 1, 0, 1, 0, 1 },
                    { 0, 1, 0, 0, 0, 1 },
            } // 탈출 실패
            , {
                    { 0, 1, 0, 0, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 0, 0, 1, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 1, 0, 1, 0 },
            } // 13
            , {
                    { 0, 1, 0, 0, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 0, 0, 1, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 1, 0, 1, 1 },
            } // 탈출 실패
            , {
                    { 0, 0, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 0 }
            } // 7
    };
    static int[][] visited; // 방문했던 좌표들
    static int minimumDistance; // 가장 적은 방문 횟수(거리), 전역 변수로 설정한 이유: dfs를 수행할 때, 서로 다른 dfs에서 비교를 하기 위함.

    public static void main(String[] args) {
        for (int i = 0; i < MAZES.length; i++) {
            findPath(MAZES[i]);
        }
    }

    public static void findPath(int[][] maze) {
        visited = new int[maze.length][maze[0].length]; // visited 초기화
        minimumDistance = Integer.MAX_VALUE; // 최소 방문 횟수 초기화
        int count = 0; // 탈출하기까지 방문 횟수 초기화
        int currentX = 0, currentY = 0; // 현재 위치(시작은 0, 0) 초기화

        visited[currentX][currentY] = -1; // (0, 0) 시작 지점 방문 완료
        count++; // 방문 횟수 1회로 시작

        // 미로 경로 탐색 시작
        dfs(currentX, currentY, count, maze);

        // 모든 경로 탐색 후, 정수 최댓값을 도달했음에도 값 도출이 안 됐을 경우 실패로 간주
        if (minimumDistance == Integer.MAX_VALUE) {
            System.out.println("미로 탈출 실패");
        } else {
            System.out.println("M: " + minimumDistance);
        }
    }

    public static void dfs(int currentX, int currentY, int count, int[][] maze) {
        final int MAZE_ROW = maze.length;
        final int MAZE_COL = maze[0].length;

        // 탈출구에 도착했으면 종료
        if (currentX == MAZE_ROW - 1 && currentY == MAZE_COL - 1) {
            minimumDistance = minimumDistance < count ? minimumDistance : count;
            return;
        }

        // 왼쪽에 길이 있고, 방문한 적이 없는 경우
        if (currentX > 0 && maze[currentX - 1][currentY] == 0 && visited[currentX - 1][currentY] != -1) {
            visited[currentX - 1][currentY] = -1;
            dfs(currentX - 1, currentY, count + 1, maze); // 다음 칸으로 이동(count + 1)하고 다시 탐색
            visited[currentX - 1][currentY] = 0; // 다른 탐색에 영향을 끼치지 않기 위해 원복
        }

        // 위쪽에 길이 있고, 방문한 적이 없는 경우
        if (currentY > 0 && maze[currentX][currentY - 1] == 0 && visited[currentX][currentY - 1] != -1) {
            visited[currentX][currentY - 1] = -1;
            dfs(currentX, currentY - 1, count + 1, maze);
            visited[currentX][currentY - 1] = 0;
        }

        // 오른쪽에 길이 있고, 방문한 적이 없는 경우
        if (currentX < MAZE_ROW - 1 && maze[currentX + 1][currentY] == 0 && visited[currentX + 1][currentY] != -1) {
            visited[currentX + 1][currentY] = -1;
            dfs(currentX + 1, currentY, count + 1, maze);
            visited[currentX + 1][currentY] = 0;
        }

        // 아래쪽에 길이 있고, 방문한 적이 없는 경우
        if (currentY < MAZE_COL - 1 && maze[currentX][currentY + 1] == 0 && visited[currentX][currentY + 1] != -1) {
            visited[currentX][currentY + 1] = -1;
            dfs(currentX, currentY + 1, count + 1, maze);
            visited[currentX][currentY + 1] = 0;
        }
    }
}