package queue;

/**
 * MyArrayQueue
 *
 * @author sadlay
 */
public class MyArrayQueue<E> implements MyQueue<E> {
    private Object[] elementData;
    int head;
    int tail;

    public MyArrayQueue() {
        this.elementData = new Object[10];
    }

    @Override
    public int size() {
        return (tail - head + elementData.length) % elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean offer(E e) {
        elementData[tail++] = e;
        tail %= elementData.length;
        if (tail == head) {
            doubleCapacity();
        }
        return true;
    }

    private void doubleCapacity() {
        assert head == tail;
        int l = elementData.length;
        int h = head;
        int n = l - h;
        int newCapacity = l << 1;
        if (newCapacity < 0) {
            throw new IllegalStateException("Sorry, queue too big");
        }
        Object[] a = new Object[newCapacity];
        System.arraycopy(elementData, h, a, 0, n);
        System.arraycopy(elementData, 0, a, n, h);
        elementData = a;
        head = 0;
        tail = l;
    }

    @Override
    public E poll() {
        if (isEmpty()) {// element is null if queue empty
            return null;
        }
        E e = (E) elementData[head];
        elementData[head++] = null;
        head %= elementData.length;
        return e;
    }

    @Override
    public E peek() {
        return (E) elementData[head];
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            poll();
        }
        head = tail = 0;
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyArrayQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.offer("f");
        queue.offer("g");
        queue.offer("h");
        queue.offer("i");
        queue.offer("j");
        queue.offer("k");
        queue.offer("l");
        queue.offer("m");
        queue.offer("n");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
