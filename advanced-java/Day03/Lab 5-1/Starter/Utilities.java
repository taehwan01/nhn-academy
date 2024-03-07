import java.util.Scanner;

public class Utilities {
    public static int max(int i, int j) {
        if (i > j)
            return i;
        else
            return j;
    }
    public static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
}

class Test {
    public static void main(String[] args) {
        int i = 5, j = 6;
        Utilities.swap(i, j);
        System.out.printf("%d, %d", i, j);
    }
}