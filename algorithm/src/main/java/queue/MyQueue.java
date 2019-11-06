package queue;

/**
 * Queue
 *
 * @author sadlay
 */
public interface MyQueue<E> {

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int size();

    /**
     * Returns {@code true} if this queue contains no elments.
     *
     * @return {@code true} if this queue contains no elements
     */
    boolean isEmpty();

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately
     * without violation capacity restrictions.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue,else {@code false}
     */
    boolean offer(E e);

    /**
     * Retrieves and remove the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();

    /**
     * Removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     */
    void clear();

}
