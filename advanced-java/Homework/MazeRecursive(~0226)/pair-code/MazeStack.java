import java.util.Stack;

public class MazeStack {
    private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    private Stack<int[]> stack = new Stack<>();

    private Maze maze;

    MazeStack(Maze maze) {
        this.maze = maze;
    }

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
        MazeStack mazeStack = new MazeStack(new Maze(bb));

        if (mazeStack.findPath()) {
            System.out.println("----도착 경로----");
            mazeStack.maze.print();
        } else {
            System.out.println("도달 실패!");
        }

    }

    boolean findPath() {
        if (maze.canNotMove(0, 0)) {
            return false;
        }

        stack.push(new int[] { 0, 0 });

        while (!stack.empty()) {
            int x = stack.peek()[0];
            int y = stack.peek()[1];

            maze.mark(x, y);

            if (maze.isArrive(x, y)) {
                return true;
            }

            boolean flag = false;
            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (maze.canNotMove(nx, ny)) {
                    continue;
                }

                flag = true;
                stack.push(new int[] { nx, ny });
                break;
            }

            if (!flag) {
                maze.remove(x, y);
                stack.pop();
            }
        }

        return false;
    }
}
