import java.util.Arrays;

public class DijkstraMaze {
    final static int[][][] MAZES = {
            {
                    { 0, 1, 0, 1, 0, 1 },
                    { 0, 1, 1, 1, 0, 1 },
                    { 0, 0, 0, 1, 0, 1 },
                    { 0, 1, 0, 1, 0, 1 },
                    { 0, 1, 0, 0, 0, 0 },
            }, // 10
            {
                    { 0, 1, 0, 1, 0, 1 },
                    { 0, 1, 1, 1, 0, 1 },
                    { 0, 0, 0, 1, 0, 1 },
                    { 0, 1, 0, 1, 0, 1 },
                    { 0, 1, 0, 0, 0, 1 },
            }, // 탈출 실패
            {
                    { 0, 1, 0, 0, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 0, 0, 1, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 1, 0, 1, 0 },
            }, // 13
            {
                    { 0, 1, 0, 0, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 0, 0, 1, 0 },
                    { 0, 1, 0, 1, 0 },
                    { 0, 1, 0, 1, 1 },
            }, // 탈출 실패
            {
                    { 0, 0, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 1 },
                    { 0, 0, 0 }
            } // 7
    };
    static final int WALL = 1;
    static final int VISITED = -1;
    static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        for (int i = 0; i < MAZES.length; i++) {
            int[][] maze = MAZES[i];
            int shortestPathLength = findShortestPathLength(maze);
            if (shortestPathLength == INFINITY) {
                System.out.println("미로 탈출 실패");
            } else {
                System.out.println("M: " + shortestPathLength);
            }
        }
    }

    public static int findShortestPathLength(int[][] maze) {
        int[][] mazeGraph = mazeToGraph(maze);
        int[] distances = dijkstra(mazeGraph);
        return distances[maze.length * maze[0].length - 1];
    }

    public static int[][] mazeToGraph(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] graph = new int[n * m][n * m];
        for (int[] row : graph) {
            Arrays.fill(row, INFINITY);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] != WALL) {
                    int node = i * m + j;
                    if (i > 0 && maze[i - 1][j] != WALL) {
                        graph[node][(i - 1) * m + j] = WALL;
                    }
                    if (j > 0 && maze[i][j - 1] != WALL) {
                        graph[node][i * m + (j - 1)] = WALL;
                    }
                    if (i < n - 1 && maze[i + 1][j] != WALL) {
                        graph[node][(i + 1) * m + j] = WALL;
                    }
                    if (j < m - 1 && maze[i][j + 1] != WALL) {
                        graph[node][i * m + (j + 1)] = WALL;
                    }
                }
            }
        }

        return graph;
    }

    public static int[] dijkstra(int[][] mazeGraph) {
        int n = mazeGraph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, INFINITY);
        distances[0] = 0;

        for (int i = 0; i < n; i++) {
            int u = minDistance(distances, visited);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && mazeGraph[u][v] != INFINITY && distances[u] != INFINITY &&
                        distances[u] + mazeGraph[u][v] < distances[v]) {
                    distances[v] = distances[u] + mazeGraph[u][v];
                }
            }
        }

        return distances;
    }

    public static int minDistance(int[] distances, boolean[] visited) {
        int min = INFINITY;
        int minIndex = -1;
        for (int v = 0; v < distances.length; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
