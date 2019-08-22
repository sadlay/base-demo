package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * ArrayStack
 *
 * @Author: sadlay
 * @Date: Created in 2019/8/21 16:50
 * @Modified By:IntelliJ IDEA
 */
public class ArrayStack<E> {

    // 存储元素的数组，声明为Object可以存储任意类型的数据
    private Object[] elementData;

    // 元素个数
    private int elementCount;

    // 栈的总容量
    private int capacity;

    /**
     * 默认构造一个容量为10的栈
     *
     * @return
     */
    public ArrayStack() {
        this.capacity = 10;
        this.elementData = new Object[10];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.elementData = new Object[capacity];
    }

    /**
     * 压入数据
     *
     * @param item
     * @return item
     */
    public E push(E item) {
        ensureCapacity(elementCount + 1);
        elementData[elementCount++] = item;
        return item;
    }

    /**
     * 弹出数据
     *
     * @return int
     */
    public E pop() {
        E peek = peek();
        remove(size() - 1);
        return peek;
    }

    private void remove(int topIdex) {
        // 栈顶元素置为null
        elementData[topIdex] = null;
        this.elementCount--;

    }

    /**
     * 访问栈顶数据
     *
     * @return int
     */
    public E peek() {
        int len = size();
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) elementData[elementCount - 1];
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == -1;
    }

    /**
     * 栈的容量
     *
     * @return int
     */
    public int size() {
        return elementCount;
    }


    /**
     * 查看数组是否需要扩容
     *
     * @param minCapacity
     * @return void
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity - capacity > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 扩容为原大小的两倍，最大容量为Integer的MAX_VALUE
     *
     * @param minCapacity
     * @return void
     */
    private void grow(int minCapacity) {
        int oldCapacity = capacity;
        int newCapacity = (oldCapacity << 1) - Integer.MAX_VALUE > 0 ? Integer.MAX_VALUE : (oldCapacity << 1);
        capacity = newCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        //System.out.println(stack.peek());
        stack.push(2);
        stack.push(3);
        stack.push("abc");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }

}
