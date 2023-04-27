import java.util.Comparator;
import java.util.List;

public interface Sorting<T> {
    List<Integer> sort(Graph g, Comparator<? super T> c);
}
