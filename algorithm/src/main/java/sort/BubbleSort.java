package sort;

/**
 * BubbleSort 冒泡排序
 *
 * @author  sadlay
 */

public class BubbleSort {

    public static int[] sort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                int k1 = array[j];
                int k2 = array[j + 1];
                if (k1 > k2) {
                    array[j + 1] = k1;
                    array[j] = k2;
                }
            }
            System.out.print("第" + i + "轮排序结果为：");
            display(array);
        }
        return array;
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        // 未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);
    }
}
