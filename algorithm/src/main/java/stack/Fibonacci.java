package stack;

import java.util.Arrays;

/**
 * Fibonacci斐波那契数列
 *
 * @author sadlay
 */

public class Fibonacci {

    public static void main(String[] args) {
        print(fibArray(10));
    }


    public static void printFib(int n) {
        for (int i = 1; i <= n; i++) {
            int[] arr = fib1Arr(i);
            for (int y = 0; y < arr.length; y++) {
                System.out.print(arr[y] + " ");
            }
            System.out.println();
        }
    }

    public static void printFib2(int n) {
        int[][] fibArr = new int[n][];
        int[] arr1 = {0};
        int[] arr2 = {0, 1};
        fibArr[0] = arr1;
        fibArr[1] = arr2;
        for (int i = 2; i < n; i++) {
            fibArr[i] = Arrays.copyOf(fibArr[i - 1], i + 1);
            fibArr[i][i] = fib2(i + 1);
        }
        print(fibArr);
    }

    public static int[][] fibArray(int n) {
        if (n == 1) {
            return new int[][]{{0}};
        }
        if (n == 2) {
            return new int[][]{{0}, {0, 1}};
        }
        int[][] arr = Arrays.copyOf(fibArray(n - 1), n);
        arr[n - 1] = Arrays.copyOf(arr[n - 2], n);
        arr[n - 1][n - 1] = fib2(n);
        return arr;
    }

    public static void print(int[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }


    public static int fib1(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The parameter: " + n + " must be greater than or equal to 1");
        }
        if (n <= 2) {
            return n - 1;
        }
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public static int[] fib1Arr(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The parameter: " + n + " must be greater than or equal to 1");
        }
        int[] arr = new int[n];
        if (n == 1) {
            arr[0] = 0;
            return arr;
        }
        if (n == 2) {
            arr[0] = 0;
            arr[1] = 1;
            return arr;
        }
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int fib2(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The parameter: " + n + " must be greater than or equal to 1");
        }
        if (n <= 2) {
            return n - 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }
}
