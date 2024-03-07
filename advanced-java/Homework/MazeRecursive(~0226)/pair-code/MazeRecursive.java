class MazeRecursive {
    private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private Maze maze;

    public static void main(String[] args) {
        int[][] bb = {
                { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 0, 1, 0, 0 },
        };
        MazeRecursive recur = new MazeRecursive(new Maze(bb));

        if (recur.findPath(0, 0)) {
            System.out.println("----도착 경로----");
            recur.maze.print();
        } else {
            System.out.println("도달 실패!");
        }

    }

    MazeRecursive(Maze maze) {
        this.maze = maze;
    }

    boolean findPath(int x, int y) {
        if (maze.canNotMove(x, y)) {
            return false;
        }

        maze.mark(x, y);

        if (maze.isArrive(x, y)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (findPath(nx, ny)) {
                return true;
            }
        }

        maze.remove(x, y);

        return false;
    }

}