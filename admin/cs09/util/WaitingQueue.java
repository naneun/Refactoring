package cs09.util;

import cs09.model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WaitingQueue {
    private Queue<User> queue;

    public WaitingQueue() {
        this.queue = new LinkedList<>(List.of(
                new User(4), new User(8), new User(10), new User(12), new User(16)));
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public User callUser() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("There are no users waiting.");
        }
        return queue.poll();
    }
}
