public class Node<T> {
    protected String id;
    private T prev;
    private T next;

    public Node(String id) {
        this.id = id;
    }

    public T prev() {
        return prev;
    }

    public void setPrev(T t) {
        prev = t;
    }

    public T next() {
        return next;
    }

    public void setNext(T t) {
        next = t;
    }
}
