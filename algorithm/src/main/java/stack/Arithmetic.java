package stack;

/**
 * Arithmetic
 * 利用栈进行四则运算
 *
 * @Author: sadlay
 * @Date: Created in 2019/11/6 8:58
 * @Modified By:IntelliJ IDEA
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
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }

    private double arithmeticPostfix(String text) {
        MyStack<Double> stack = new MyArraryStack<>();
        String[] s1 = text.split("\\ ");
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
