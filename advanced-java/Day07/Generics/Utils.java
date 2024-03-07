import java.util.Arrays;
import java.util.List;

public class Utils {
    public <T> List<T> arrayToList(T[] array) {
        return Arrays.asList(array);
    }

    public List<Integer> arrayToList(Integer[] array) {
        return Arrays.asList(array);
    }
}