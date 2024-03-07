public class Box<T> {
    T item;

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }
}

class Test {
    public static void main(String[] args) {
        Box<String> box = new Box<>("ABC");
        Box<Comparable<String>> box2 = new Box<>("Hello");
        Box<Integer> box3 = new Box<>(1);
    }
}