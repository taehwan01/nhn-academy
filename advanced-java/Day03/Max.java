public class Max {
    static int max(int i, int j) {
        return i > j ? i : j;
    }

    static int max3(int i, int j, int k) {
        // return max(i, j) > k ? max(i, j) : k;
        return max(max(i, j), k);
    }

    public static void main(String[] args) {
        int a = 10, b = 20, c = 37;
        System.out.println("max2(" + a + ", " + b + ") = " + max(a, b));
        System.out.println("max3(" + a + ", " + b + ", " + c + ") = " + max3(a, b, c));
    }
}