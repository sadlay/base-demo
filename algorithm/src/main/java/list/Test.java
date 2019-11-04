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
        print(myList);

        myList.add(8);
        System.out.println("after add element: " + 8);
        print(myList);

        myList.add(1, 7);
        System.out.println("after add element: " + 7 + " at the index: " + 1);
        print(myList);

        myList.remove(2);
        System.out.println("after remove element at the index: " + 2);

        print(myList);
    }

    private static void print(MyList myList){
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}
