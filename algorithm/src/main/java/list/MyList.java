package list;

/**
 * 线性表接口
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/1 9:26
 * @Modified By:IntelliJ IDEA
 */
public interface MyList<E> {

    int size();

    boolean isEmpty();

    E get(int index);

    boolean add(E e);

    void add(int index, E e);

    E remove(int index);
}
