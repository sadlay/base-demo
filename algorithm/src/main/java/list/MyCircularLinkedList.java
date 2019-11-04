package list;

/**
 * MyCircleLinkedList
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/4 13:39
 * @Modified By:IntelliJ IDEA
 */

public class MyCircularLinkedList<E> implements MyList<E> {

    private int size;

    private Node<E> head;

    private Node<E> currentNode;

    public MyCircularLinkedList() {
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
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }


    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<>(null, e, head);
        if (head == null) {
            newNode.prev = newNode;
            newNode.next = newNode;
            head = newNode;
        } else {
            Node<E> prev = head.prev;
            head.prev = newNode;
            newNode.prev = prev;
            prev.next = newNode;
        }
        size++;
    }

    private void linkBefore(E e, Node<E> oldNode) {
        Node<E> prev = oldNode.prev;
        Node<E> newNode = new Node<>(prev, e, oldNode);
        oldNode.prev = newNode;
        if (oldNode == head) {
            head = newNode;
        }
        prev.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, node(index));
        }
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private E unlink(Node<E> node) {
        E item = node.item;

        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (node == head) {
            head = next;
        }
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        node.item = null;
        size--;
        return item;
    }

    public E prev() {
        checkSize();
        E item;
        if (currentNode == null) {
            currentNode = head;
        }

        item = currentNode.item;
        currentNode = currentNode.prev;
        return item;
    }

    public E next() {
        checkSize();
        E item;
        if (currentNode == null) {
            currentNode = head;
        }

        item = currentNode.item;
        currentNode = currentNode.next;
        return item;
    }

    private void checkSize() {
        if (size == 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(0));
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private Node<E> node(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyCircularLinkedList<String> list = new MyCircularLinkedList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        list.add(2, "阳泉");
        list.add(0, "太原");

        

        for (int i = 0; i < 100; i++) {
            System.out.println(list.next());
        }
    }
}
