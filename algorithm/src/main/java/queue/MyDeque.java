package queue;

/**
 * MyDeque
 *
 * @author sadlay
 */

public interface MyDeque<E> extends MyQueue<E> {

    /**
     * Inserts the specified element at the front of this deque unless it would
     * violate capacity restrictions.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     */
    boolean offerFirst(E e);

    /**
     * Inserts the specified element at the end of this deque unless it would
     * violate capacity restrictions.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     * {@code false}
     */
    boolean offerLast(E e);

    /**
     * Retrieves and removes the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    E pollFirst();

    /**
     * Retrieves and removes the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return E the tail of this deque, or {@code} if this deque is empty
     */
    E pollLast();

    /**
     * Retrieves, but not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or{@code null} if this deque is empty
     */
    E peekFirst();

    /**
     * Retrieves, but not remove, the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    E peekLast();

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
