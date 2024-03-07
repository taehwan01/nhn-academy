public class OverLoading {
    static int sum(int a, int b) {
        return a + b;
    }

    static double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(sum(3, 5)); // sum(int a, int b) 호출 -> return 8
        System.out.println(sum(2.8, 3.6)); // sum(double a, double b) 호출 -> return 6.4
    }
}