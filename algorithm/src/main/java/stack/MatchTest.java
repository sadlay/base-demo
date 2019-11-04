package stack;

import java.util.HashMap;
import java.util.Map;

/**
 * MatchTest
 * 利用栈进行最近匹配测试
 *
 * @Author: sadlay
 * @Date: Created in 2019/8/22 13:49
 * @Modified By:IntelliJ IDEA
 */

public class MatchTest {

    private static final Map<Character, Character> bracket;

    static {
        bracket = new HashMap<>();
        bracket.put(')', '(');
        bracket.put(']', '[');
        bracket.put('}', '{');
        bracket.put('>', '<');
    }

    public static boolean isMatch(String str) {
        MyArraryStack<Character> stack = new MyArraryStack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            // 是否为左括号
            if (bracket.containsValue(c)) {
                stack.push(c);
            }

            // 是否为右括号
            if (bracket.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                // 若左右括号匹配
                if (stack.peek() == bracket.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // 如果stack不为空，说明左侧有符号没有右侧匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String Str = "12<a[b{c}]>";
        boolean match = isMatch(Str);
        System.out.println(match);
    }
}
