import java.util.Iterator;

public class ArrayListIterator implements Iterable {
    private ArrayList list;
    private int index;

    public ArrayListIterator(ArrayList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {

        // 다음 데이터가 있으면 true, 없으면 false 반환
        return this.list.size() > this.index ? true : false;
    }

    public int next() {
        // 다음 데이터 반환
        return this.list.get(this.index++);
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
