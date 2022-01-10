import java.util.ArrayList;
import java.util.List;

public class Editor<T extends Node> {
    private T front;
    private T back;
    private int count;

    public Editor() { }

    public Editor(T[] nodeArr) {
        for (T node : nodeArr) {
            add(node);
        }
    }

    public List<T> toCollection() {
        List<T> TList = new ArrayList<>();
        T itr = front;
        while (itr != null) {
            TList.add(itr);
            itr = (T) itr.next();
        }
        return TList;
    }

    public void itinerate() {
        StringBuilder sb = new StringBuilder("|---");
        T itr = front;
        while (itr != null) {
            sb.append("[" + itr.id);
            if (itr instanceof Video) {
                sb.append(", " + ((Video) itr).getPlayTime() + "sec");
            }
            sb.append("]---");
            itr = (T) itr.next();
        }
        sb.append("[end]");
        System.out.println(sb);
    }

    public T search(int seq) {
        T itr = front;
        while (seq-- > 0 && itr != null) {
            itr = (T) itr.next();
        }
        return itr;
    }

    public T search(String id) {
        T itr = front;
        while (itr != null) {
            if (itr.id.equals(id)) {
                break;
            }
            itr = (T) itr.next();
        }
        return itr;
    }

    public boolean add(T node) {
        if (search(node.id) != null) {
            return false;
        }
        if (front == null) {
            front = back = node;
            ++count;

            return true;
        }
        back.setNext(node);
        node.setPrev(back);
        back = node;
        ++count;

        return true;
    }

    public boolean insert(T node, int seq) {
        if (search(node.id) != null) {
            return false;
        }
        if (seq + 1 > count) {
            back.setNext(node);
            node.setPrev(back);
            back = node;
        } else {
            T itr = search(seq);
            T prev = (T) itr.prev();
            T next = (T) itr.next();

            node.setPrev(prev);
            node.setNext(itr);
            if (prev != null) {
                prev.setNext(node);
            } else {
                front = node;
            }
            itr.setPrev(node);
        }
        ++count;

        return true;
    }

    public boolean delete(String id) {
        T itr = search(id);
        if (itr == null) {
            return false;
        }
        T prev = (T) itr.prev();
        T next = (T) itr.next();
        if (prev != null) {
            prev.setNext(next);
        } else {
            front = next;
        }
        if (next != null) {
            next.setPrev(prev);
        } else {
            back = prev;
        }
        itr = null;
        --count;

        return true;
    }

    public String render() {
        StringBuilder sb = new StringBuilder("영상클립: " + count + "개\n");
        long result = 0;
        T itr = front;
        while (itr != null) {
            if (itr instanceof Video) {
                result += ((Video) itr).getPlayTime();
            }
            itr = (T) itr.next();
        }
        sb.append("전체길이: " + result);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("---영상클립---\n");
        T itr = front;
        while (itr != null) {
            sb.append(itr.toString() + "\n");
            itr = (T) itr.next();
        }
        return sb.toString();
    }
}
