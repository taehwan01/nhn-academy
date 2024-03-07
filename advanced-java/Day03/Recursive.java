public class Recursive {
    public static void max(int value) {
        if (value < 0) {
            return;
        } else {
            System.out.println(value);
            max(value - 1);
        }
    }

    public static void main(String[] args) {
        max(10);
    }
}
