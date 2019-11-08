package queue;

/**
 * MyLinkedDeque
 *
 * @author sadlay
 */

public class MyLinkedDeque<E> implements MyDeque<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public MyLinkedDeque() {
    }

    @Override
    public boolean offerFirst(E e) {
        Node<E> node = new Node<>(e);
        return linkFirst(node);
    }

    @Override
    public boolean offerLast(E e) {
        Node<E> node = new Node<>(e);
        return linkLast(node);
    }


    @Override
    public E pollFirst() {
        return unlinkFirst();
    }


    @Override
    public E pollLast() {
        return unlinkLast();
    }


    @Override
    public E peekFirst() {
        return head == null ? null : head.item;
    }

    @Override
    public E peekLast() {
        return tail == null ? null : tail.item;
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

    private boolean linkFirst(Node<E> node) {
        Node<E> h = this.head;
        node.next = h;
        head = node;
        if (h == null) {
            tail = head;
        } else {
            h.prev = node;
        }
        size++;
        return true;
    }

    private boolean linkLast(Node<E> node) {
        Node<E> t = this.tail;
        node.prev = t;
        tail = node;
        if (t == null) {
            head = tail;
        } else {
            t.next = node;
        }
        size++;
        return true;
    }

    private E unlinkFirst() {

        Node<E> h = this.head;
        if (h == null) {
            return null;
        }
        E item = h.item;
        Node<E> next = h.next;
        h.next = null;
        h.item = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        size--;
        return item;
    }

    private E unlinkLast() {
        Node<E> t = this.tail;
        if (t == null) {
            return null;
        }
        E item = t.item;
        Node<E> prev = t.prev;
        t.item = null;
        t.prev = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        size--;
        return item;
    }

    @Override
    public void clear() {
        for (Node<E> n = head; n != null; ) {
            Node<E> next = n.next;
            n.item = null;
            n.prev = null;
            n.next = null;
            n = next;
        }
        head = tail = null;
    }

    private class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyDeque<String> queue = new MyLinkedDeque<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.pollLast();
        queue.offerFirst("d");
        queue.offer("e");
        queue.offerFirst("f");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
