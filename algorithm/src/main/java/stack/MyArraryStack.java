package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * MyArraryStack
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/4 16:32
 * @Modified By:IntelliJ IDEA
 */

public class MyArraryStack<E> implements MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elementData;
    private int size;

    public MyArraryStack() {
        elementData = new Object[DEFAULT_CAPACITY];
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
    public E peek() {
        int len = size();
        if (len == 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[len - 1];
    }

    @Override
    public E pop() {
        E item = peek();
        removeElementAt(size() - 1);
        return item;
    }

    private void removeElementAt(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int numMoved = size - 1 - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public E push(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return e;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {

        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity << 1;

        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public static void main(String[] args) {
        MyArraryStack<String> stack=new MyArraryStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
