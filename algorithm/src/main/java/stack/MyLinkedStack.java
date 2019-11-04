package stack;

import java.util.EmptyStackException;

/**
 * MyLinkedStack
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/4 16:32
 * @Modified By:IntelliJ IDEA
 */

public class MyLinkedStack<E> implements MyStack<E> {

    private Node<E> top;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    @Override
    public E pop() {
        E item = peek();
        top = top.next;
        size--;
        return item;
    }


    @Override
    public E push(E e) {
        top = new Node<E>(e, top);
        size++;
        return e;
    }

    @Override
    public void clear() {
        for (Node<E> x = top; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        top = null;
        size = 0;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyLinkedStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        stack.clear();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
