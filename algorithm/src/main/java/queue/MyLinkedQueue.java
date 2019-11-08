package queue;

/**
 * MyLinkedQueue
 *
 * @author sadlay
 */

public class MyLinkedQueue<E> implements MyQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedQueue() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offer(E e) {
        Node<E> node = new Node<>(e);
        return linkLast(node);
    }

    private boolean linkLast(Node<E> node) {
        Node<E> t = tail;
        node.prev = t;
        tail = node;
        if (head == null) {
            head = tail;
        } else {
            t.next = tail;
        }
        size++;
        return false;
    }

    @Override
    public E poll() {
        return unlinkFirst();
    }

    private E unlinkFirst() {
        Node<E> h = head;
        if (h == null) {
            return null;
        }
        Node<E> n = head.next;
        E e = head.item;
        head.next = null;
        head.item = null;

        head = n;
        if (n == null) {
            tail = null;
        } else {
            n.prev = null;
        }
        size--;
        return e;
    }

    @Override
    public E peek() {
        return head == null ? null : head.item;
    }

    @Override
    public void clear() {
        for (Node<E> h = head; head != null; ) {
            h.item = null;
            Node<E> n = h.next;
            h.next = null;
            h.prev = null;
            head = n;
        }
        head = tail = null;
        size = 0;

    }

    private class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyLinkedQueue<>();
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
