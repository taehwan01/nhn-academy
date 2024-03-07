import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class StudentList<T> implements Iterable<T> {
    List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();

    }
}
