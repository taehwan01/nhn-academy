import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MyList<E extends Comparable<E>> implements Iterable<E> { // E 타입에 대해서 반복자를 반환하는 Iterable 인터페이스를 구현하도록 수정
    private List<E> list;
    private String description;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public void sort() {
        Collections.sort(this.list); // list E 타입이 정렬이 가능한 타입이어야 함. 따라서, extends Comparable<E> 제약을 추가
    }

    // 메소드 오버로딩
    public void sort(Comparator<E> comparator) {
        Collections.sort(this.list, comparator);
    }

    public List<E> getList() {
        return this.list;
    }

    public void add(E e) {
        list.add(e);
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
