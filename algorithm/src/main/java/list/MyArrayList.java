package list;

/**
 * MyArrayList
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/1 9:54
 * @Modified By:IntelliJ IDEA
 */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elementsData;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementsData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementsData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public MyArrayList() {
        this.elementsData = EMPTY_ELEMENTDATA;
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
        rangeCheck(index);
        return elementsData(index);
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private String outOfBoundMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private E elementsData(int index) {
        return (E) elementsData[index];
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementsData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementsData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementsData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementsData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        growCopy(newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private void growCopy(int newCapacity) {
        if (newCapacity - elementsData.length > 0) {
            Object[] newArray = new Object[newCapacity];

            for (int i = 0; i < elementsData.length; i++) {
                newArray[i] = elementsData[i];
                elementsData[i] = null;
            }
            elementsData = newArray;
        }
    }

    private void addCopy(int index) {
        for (int i = size; i > index; i--) {
            elementsData[i] = elementsData[i - 1];
        }
    }

    private void removeCopy(int index) {
        for (int i = index; i < size; i++) {
            elementsData[i] = elementsData[i + 1];
        }
    }

    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1);
        addCopy(index);
        elementsData[index] = e;
        size++;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        E oldValue = elementsData(index);

        int numMoved = size - 1 - index;
        if (numMoved > 0) {
            removeCopy(index);
        }
        elementsData[--size] = null;
        return oldValue;
    }


    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(5);
        myList.add(1);
        myList.add(2);


        System.out.println("begin size: " + myList.size());
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();

        myList.add(1, 7);
        System.out.println("after add element size: " + myList.size());
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
        myList.remove(2);
        System.out.println("after remove element size: " + myList.size());

        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }

}
