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

    public static int swap2(int i, int j) {
        return i;
    }

    public static String reverseString(String s) {
        int len = s.length();
        return s.charAt(len - 1) + reverseString(s.substring(0, len - 1));
    }
    // abcd -> dcba
}
