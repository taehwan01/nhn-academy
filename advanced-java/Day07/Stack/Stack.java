public class Stack<E> { // <T> is a generic type
    private E[] elements;
    private int index = 0;

    public Stack(int size) {
        this.elements = (E[]) new Object[size];
    }

    public void push(E item) {
        this.elements[this.index++] = item;
    }

    public Object pop() {
        return this.elements[--index];
    }
}

class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(10);
        stack.push(1);
        stack.push(16);
        stack.push(1531);
        // stack.push((int) 2.8);
        // stack.push("Hello, World!");

        int i = (int) stack.pop();
    }
}