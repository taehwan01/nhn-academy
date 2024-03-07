public class Hello {
    public static void main(String[] args) {
        int[] arr = { 5, 10 };
        System.out.println("BEFORE SWAP: " + arr[0] + ", " + arr[1]);
        swap(arr);
        System.out.println("AFTER SWAP: " + arr[0] + ", " + arr[1]);
    }

    public static void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}
