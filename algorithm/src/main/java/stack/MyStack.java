package stack;

/**
 * 栈的方法定义接口
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/4 15:55
 * @Modified By:IntelliJ IDEA
 */
public interface MyStack<E> {

    int size();

    boolean isEmpty();

    E peek();

    E pop();

    E push(E e);

    void clear();
}
