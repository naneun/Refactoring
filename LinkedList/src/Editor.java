import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("rawtypes")
public class Editor<T extends Node> implements LinkedList<T> {
    private T front;
    private T back;
    private int count;

    public Editor(T[] nodeArr) {
        for (T node : nodeArr) {
            add(node);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> toCollection() {
        List<T> TList = new ArrayList<>();
        T itr = front;
        while (Objects.nonNull(itr)) {
            TList.add(itr);
            itr = (T) itr.next();
        }
        return TList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void travel() {
        StringBuilder sb = new StringBuilder("|---");
        T itr = front;
        while (Objects.nonNull(itr)) {
            sb.append("[").append(itr.id);
            if (itr instanceof Video) {
                sb.append(", ").append(((Video) itr).getPlayTime()).append("sec");
            }
            sb.append("]---");
            itr = (T) itr.next();
        }
        sb.append("[end]");
        System.out.println(sb);
    }

    @SuppressWarnings({"SingleStatementInBlock", "unchecked"})
    @Override
    public T search(int seq) {
        T itr = front;
        while (seq-- > 0 && Objects.nonNull(itr)) {
            itr = (T) itr.next();
        }
        return itr;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T search(String id) {
        T itr = front;
        while (Objects.nonNull(itr)) {
            if (itr.id.equals(id)) {
                break;
            }
            itr = (T) itr.next();
        }
        return itr;
    }

    public boolean isExist(T node) {
        return Objects.nonNull(search(node.id));
    }

    @SuppressWarnings("unchecked")
    public void addNode(T node) {
        if (Objects.isNull(front)) {
            front = back = node;
            ++count;
            return;
        }
        back.setNext(node);
        node.setPrev(back);
        back = node;
        ++count;
    }

    @Override
    public void add(T node) {
        if (isExist(node)) {
            return;
        }
        addNode(node);
    }

    @SuppressWarnings("unchecked")
    public void insertNode(T node, int seq) {
        T itr = search(seq);
        T prev = (T) itr.prev();

        node.setPrev(prev);
        node.setNext(itr);
        if (Objects.nonNull(prev)) {
            prev.setNext(node);
        } else {
            front = node;
        }
        itr.setPrev(node);
        ++count;
    }

    @Override
    public void insert(T node, int seq) {
        if (isExist(node)) {
            return;
        }
        if (seq + 1 > count) {
            addNode(node);
            return;
        }
        insertNode(node, seq);
    }

    @SuppressWarnings("unchecked")
    public void deleteNode(T node) {
        T prev = (T) node.prev();
        T next = (T) node.next();
        if (Objects.nonNull(prev)) {
            prev.setNext(next);
        } else {
            front = next;
        }
        if (Objects.nonNull(next)) {
            next.setPrev(prev);
        } else {
            back = prev;
        }
        node = null;
        --count;
    }

    @Override
    public void delete(String id) {
        T node = search(id);
        if (!isExist(node)) {
            return;
        }
        deleteNode(node);
    }

    @SuppressWarnings("unchecked")
    public String render() {
        StringBuilder sb = new StringBuilder("영상클립: " + count + "개\n");
        long result = 0;
        T itr = front;
        while (Objects.nonNull(itr)) {
            if (itr instanceof Video) {
                result += ((Video) itr).getPlayTime();
            }
            itr = (T) itr.next();
        }
        sb.append("전체길이: ").append(result);
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("---영상클립---\n");
        T itr = front;
        while (Objects.nonNull(itr)) {
            sb.append(itr).append("\n");
            itr = (T) itr.next();
        }
        return sb.toString();
    }
}
