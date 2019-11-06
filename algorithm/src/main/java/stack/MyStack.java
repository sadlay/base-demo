package stack;

/**
 * 栈的方法定义接口
 *
 * @author sadlay
 */
public interface MyStack<E> {
    
    /**
     * get the size of stack element
     *
     * @return the size of stack
     */
    int size();

    boolean isEmpty();

    E peek();

    E pop();

    E push(E e);

    void clear();
}
