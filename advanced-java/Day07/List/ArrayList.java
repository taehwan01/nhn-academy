/*
 * 배열 사용
 * List 상속
 * Integer로 한정
 */

public class ArrayList implements List {
    private final int CAPACITY = 50;

    private int[] arr;
    private int size;

    public ArrayList() {
        this.size = 0;
        this.arr = new int[50];
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(int value) {
        if (size == CAPACITY) {
            throw new ArrayIndexOutOfBoundsException("용량 초과");
        }
        arr[size] = value;
        ++size;
    }

    @Override
    public void remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
        }
        for (int i = idx; i < size - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        --size;
    }

    @Override
    public int get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException("인덱스 범위 초과");
        }
        return arr[idx];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < size; ++i) {
            sb.append(arr[i]).append(",");
        }
        sb.append(")");
        return sb.toString();
    }
}
