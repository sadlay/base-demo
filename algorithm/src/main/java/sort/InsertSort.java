package sort;

/**
 * InsertSort 插入排序
 *
 * @Author: sadlay
 * @Date: Created in 2019/8/21 15:14
 * @Modified By:IntelliJ IDEA
 */


public class InsertSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            // 第 i轮排序的结果为
            System.out.print("第" + i + "轮排序后的结果为:");
            display(array);
        }
        return array;
    }

    // 遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
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
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
    }

}
