package me.cynatix.radiumduels.queue;

import javax.annotation.Nullable;
import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */

public interface Queue<T> extends Comparable<T> {

    /**
     * The type of the queue whether its unrated or competitive
     * @return type of queue
     */
    QueueType type();

    /**
     *
     * @return The queue
     */
    PriorityQueue<T> getQueue();

    /**
     * Add an entry to the queue
     * @param t entry
     */
    default void add(T t){
        getQueue().offer(t);
    }

    /**
     * Get the peek of the queue (the top)
     * @returns the top of the queue
     */
    default @Nullable T peek(){
        return getQueue().peek();
    }

    /**
     * Get the peek of the queue (the top) and also removing it
     * @returns the top of the queue
     */
    default @Nullable T next() {
        return getQueue().poll();
    }

    /**
     * Move to the next entry in the queue
     */
    default void move() {
        onQueueUpdate(getQueue().poll());
    }

    /**
     * This method is called whenever the queue is updated
     * @param next the new entry
     */

    void onQueueUpdate(T next);
}
