package stack;

/**
 * StringReversalTest 字符串翻转测试
 *
 * @Author: sadlay
 */
public class StringReversalTest {

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("-----翻转前-----");
        System.out.println(str);
        ArrayStack stack = new ArrayStack();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        System.out.println("-----翻转后-----");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
