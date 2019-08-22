package stack;

import java.util.Arrays;
import java.util.Collections;

/**
 * MyStack
 *
 * @Author: sadlay
 * @Date: Created in 2019/8/21 16:33
 * @Modified By:IntelliJ IDEA
 */

public class  MyStack {

    private int[] array;
    private int maxSize;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    /**
     * 压入数据
     *
     * @param value
     * @return void
     */
    public void push(int value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        } else {
            System.out.println("堆栈已满");
        }
    }

    /**
     * 弹出数据
     *
     * @return int
     */
    public int pop() {
        return array[top--];
    }

    /**
     * 访问栈顶数据
     *
     * @return int
     */
    public int peek() {
        return array[top];
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断栈是否满了
     *
     * @return boolean
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
       String a="";
        byte[] bytes = a.getBytes();

    }
}
