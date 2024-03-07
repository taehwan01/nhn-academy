public class Stack {
    int[] elements;
    int index;

    public Stack(int size) {
        this.elements = new int[size];
    }

    public void push(int element) {
        this.elements[index++] = element;
    }

    public int pop() {
        return this.elements[--index];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        int poppedOut;

        stack.push(1);
        stack.push(2);

        poppedOut = stack.pop();
        System.out.println(poppedOut);

        poppedOut = stack.pop();
        System.out.println(poppedOut);
    }
}
