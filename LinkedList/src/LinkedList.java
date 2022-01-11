import java.util.List;

public interface LinkedList<T> {
    List<T> toCollection();
    void travel();
    T search(int seq);
    T search(String id);
    @SuppressWarnings("UnusedReturnValue")
    boolean add(T node);
    @SuppressWarnings("UnusedReturnValue")
    boolean insert(T node, int seq);
    @SuppressWarnings("UnusedReturnValue")
    boolean delete(String id);
}
