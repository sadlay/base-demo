package list;

/**
 * Test
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/4 11:23
 * @Modified By:IntelliJ IDEA
 */
public class Test {


    public static void main(String[] args) {
        MyList<Integer> myList;
//        myList= new MyArrayList<>(); //测试顺序表
        myList = new MyLinkedList<>(); //测试链表
        test(myList);
    }

    private static void test(MyList<Integer> myList) {
        myList.add(5);
        myList.add(1);
        myList.add(2);

        System.out.println("begin: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
        myList.add(1, 7);
        System.out.println("after add element: " + 7 + " from the index: " + 1);
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
        myList.remove(2);
        System.out.println("after remove element from the index: " + 2);

        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}
