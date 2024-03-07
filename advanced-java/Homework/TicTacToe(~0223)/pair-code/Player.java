import java.util.Arrays;
import java.util.Scanner;

class Player {
    int symbol;
    static int[][] board = Board.board;

    static void personTurn(Scanner scanner) {
        int[] coord = pickPersonCoord(scanner);
        Board.placeMark(coord[0], coord[1], 1);
    }

    static void computerTurn() {
        int[] coord = pickComputerCoord(board);
        Board.placeMark(coord[0], coord[1], 2);
    }

    static int[] pickPersonCoord(Scanner scanner) {
        int[] coord = { -1, -1 };

        while (true) {
            String input = scanner.nextLine();

            try {
                coord = Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if (Board.isValidMark(coord[0], coord[1])) {
                    break;
                } else {
                    throw new Exception("올바르지않은 입력값");
                }
            } catch (Exception e) {
                System.out.println("입력값이 올바르지 않습니다. 다시 입력해주세요.");
            }

        }

        return coord;
    }

    static int[] pickComputerCoord(int board[][]) {
        int[] coord = { -1, -1 };

        while (true) {
            coord[0] = (int) (Math.random() * 3);
            coord[1] = (int) (Math.random() * 3);
            if (Board.isValidMark(coord[0], coord[1])) {
                break;
            }
        }

        return coord;
    }

}