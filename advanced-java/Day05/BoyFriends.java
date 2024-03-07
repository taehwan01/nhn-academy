import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoyFriends implements Iterable<BoyFriend> { // Iterable: 군집인데, 열거가능한.
    List<BoyFriend> list = new ArrayList<>();

    public void add(BoyFriend boy) {
        this.list.add(boy);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    @Override
    public Iterator<BoyFriend> iterator() {
        return this.list.iterator();
    }
}
