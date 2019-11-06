package stack;

/**
 * Arithmetic
 * 利用栈进行四则运算
 *
 * @author sadlay
 */

public class Arithmetic {


    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        String postfix = arithmetic.postfix("9 + ( 3 - 1 ) * 6 + 10 / 10");
        System.out.println(postfix);
        // double v = arithmetic.arithmeticPostfix("9 3 1 - 3 * + 10 2 / + ");
        double v = arithmetic.arithmeticPostfix(postfix);
        System.out.println(v);
    }

    /**
     * 中缀表达式转后缀表达式
     * 规则如下；
     * 从左到右遍历中缀表达式的每个数字和符号，若是数字则直接输出；
     * 若是符号，则判断与栈顶符号的优先级，是右括号或优先级不高于栈顶符号（乘除优先加减）则栈顶元素依次出栈并输出，并将当前符号进栈。
     * 一直到最终输出后缀表达式为止。
     *
     * @param infix 中缀表达式
     * @return 后缀表达式
     */
    private String postfix(String infix) {
        StringBuilder sb = new StringBuilder();
        String[] arr = infix.split("\\ ");
        MyStack<String> stack = new MyArraryStack<>();
        for (int i = 0; i < arr.length; i++) {

            String a = arr[i];
            if (isNum(a)) {
                sb.append(a).append(" ");
            } else if (isOperator(a)) {
                while (!stack.isEmpty()
                        && !stack.peek().equals("(")
                        && priorityCompare(a, stack.peek()) < 0) {
                    sb.append(stack.pop()).append(" ");
                }
                stack.push(a);
            } else if (a.equals("(")) {
                stack.push(a);
            } else if (a.equals(")")) {
                while (!stack.isEmpty()
                        && !stack.peek().equals("(")) {
                    String pop = stack.pop();
                    sb.append(pop).append(" ");
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }

    /**
     * 对后缀表达式进行计算
     * 规则如下：
     * 从左至右遍历表达式的每个数字和符号，遇到是数字就进栈；
     * 遇到是符号，就将处于栈顶的两个数字出栈，进行运算，并将结果入栈。
     * 一直得到最终获得结果。
     *
     * @param postfix 后缀表达式
     * @return 结果
     */
    private double arithmeticPostfix(String postfix) {
        MyStack<Double> stack = new MyArraryStack<>();
        String[] s1 = postfix.split("\\ ");
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            if (isNum(s2)) {
                stack.push(Double.valueOf(s2));
            } else {
                Double n1 = stack.pop();
                Double n2 = stack.pop();
                double result = operate(n2, n1, s2);
                stack.push(result);
            }

        }
        return stack.pop();
    }

    private double operate(Double n2, Double n1, String c) {
        double result = 0;
        switch (c) {
            case "+":
                result = n2 + n1;
                break;
            case "-":
                result = n2 - n1;
                break;
            case "*":
                result = n2 * n1;
                break;
            case "/":
                result = n2 / n1;
                break;
        }
        return result;
    }

    private boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (ch < 48 || ch > 57) {
                return false;
            }
        }
        return true;
    }

    private boolean isOperator(String str) {
        return str.equals("+")
                || str.equals("-")
                || str.equals("*")
                || str.equals("/");
    }

    private int priorityCompare(String s1, String s2) {
        switch (s1) {
            case "+":
            case "-":
                return (s2.equals("*") || s2.equals("/") ? -1 : 0);
            case "*":
            case "/":
                return (s2.equals("+") || s2.equals("-") ? 1 : 0);
        }
        return 1;
    }
}
