package list;

/**
 * 线性表接口
 *
 * @author sadlay
 */
public interface MyList<E> {

    int size();

    boolean isEmpty();

    E get(int index);

    boolean add(E e);

    void add(int index, E e);

    E remove(int index);

    void clear();
}
