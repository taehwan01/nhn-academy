public class Sort {
    public static void main(String[] args) {
        int[] unsortedNumbers = { 3, 6, 7, 2, 5 };

        bubbleSort(unsortedNumbers);

        for (int i = 0; i < unsortedNumbers.length; i++) {
            int number = unsortedNumbers[i];
            if (i == unsortedNumbers.length - 1) {
                System.out.println(number);
            } else {
                System.out.print(number + ", ");
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        System.out.print("Bubble Sort: ");
        int temp;
        for (int len = arr.length; len > 0; len--) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
