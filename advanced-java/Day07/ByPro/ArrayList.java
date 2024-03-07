import java.util.Iterator;

public class ArrayList implements List, Iterable {
    private final int CAPACITY = 20;
    private int[] array;
    private int size;
    private int index;

    public ArrayList() {
        array = new int[CAPACITY];
        size = 0;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        // 다음 데이터가 있으면 true, 없으면 false 반환
        if (index < size) {
            return true;
        }
        return false;
    }

    @Override
    public int next() {
        // 다음 데이터 반환
        if (this.hasNext()) {
            return array[index++];
        }
        return -1;
    }

    @Override
    public void add(int data) {
        if (size < CAPACITY) {
            array[size] = data;
        }
        size++;
    }

    @Override
    public int remove(int index) {
        int removedElement = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return removedElement;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    public void printList() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + "  ");
        }
    }

    public int size() {
        return this.index;
    }

    public Iterator iterator() {
        return new ArrayListIterator(this);
    }
}
