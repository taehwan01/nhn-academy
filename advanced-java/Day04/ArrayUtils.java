public class ArrayUtils {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            printArray(arr[i]);
            // for (int j = 0; j < arr[i].length; j++) {
            // if (j == arr[i].length - 1)
            // System.out.print(arr[i][j]);
            // else
            // System.out.print(arr[i][j] + ", ");
            // }
        }
    }

    public static void printArrayUsingForEach(int[] arr) {
        for (int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void printArrayUsingForEach(int[][] arr) {
        for (int[] row : arr) {
            printArrayUsingForEach(row);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 2, 4, 8, 3, 6, 3, 1, 9, 5 };
        int[][] arr2D = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        printArray(arr);
        System.out.println();
        printArray(arr2D);

        System.out.println();
        System.out.println();

        printArrayUsingForEach(arr);
        System.out.println();
        printArrayUsingForEach(arr2D);
    }
}