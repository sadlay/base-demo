package queue;

/**
 * MyArraryDeque
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/7 14:57
 * @Modified By:IntelliJ IDEA
 */

public class MyArrayDeque<E> implements MyDeque<E> {
    private static final int INIT_CAPACITY = 5;
    private Object[] elementData;
    private int head;
    private int tail;

    public MyArrayDeque() {
        this.elementData = new Object[INIT_CAPACITY];
    }

    @Override
    public boolean offerFirst(E e) {
        head = (--head + elementData.length) % elementData.length;
        elementData[head] = e;
        if (tail == head) {
            doubleCapacity();
        }
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        elementData[tail] = e;
        tail = (++tail) % elementData.length;
        if (tail == head) {
            doubleCapacity();
        }
        return true;
    }

    private void doubleCapacity() {
        assert tail == head;
        int l = elementData.length;
        int h = head;
        int n = l - h;
        int newCapacity = l << 1;
        if (newCapacity < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] a = new Object[newCapacity];
        System.arraycopy(elementData, h, a, 0, n);
        System.arraycopy(elementData, 0, a, n, h);
        elementData = a;
        head = 0;
        tail = l;
    }

    @Override
    public E pollFirst() {
        if (head == tail) {
            return null;
        }
        E e = (E) elementData[head];
        elementData[head++] = null;
        head %= elementData.length;
        return e;
    }

    @Override
    public E pollLast() {
        if (head == tail) {
            return null;
        }
        tail = (--tail + elementData.length) % elementData.length;
        E e = (E) elementData[tail];
        elementData[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        return (E) elementData[head];
    }

    @Override
    public E peekLast() {
        int last = (tail + elementData.length - 1) % elementData.length;
        return (E) elementData[last];
    }

    @Override
    public int size() {
        return (tail - head + elementData.length) % elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public void clear() {
        int h = head;
        int t = tail;
        if (h != t) {
            head = tail = 0;
            int i = h;
            do {
                elementData[i] = null;
                i = (++i) % elementData.length;
            } while (i != t);
        }
    }

    public static void main(String[] args) {
        MyDeque<String> queue = new MyArrayDeque<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offerFirst("d");
        queue.offer("e");
        queue.offerFirst("f");
        queue.pollLast();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
