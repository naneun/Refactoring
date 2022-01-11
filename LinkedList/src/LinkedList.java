import java.util.List;

public interface LinkedList<T> {
    List<T> toCollection();
    void travel();
    T search(int seq);
    T search(String id);
    void add(T node);
    void insert(T node, int seq);
    void delete(String id);
}
