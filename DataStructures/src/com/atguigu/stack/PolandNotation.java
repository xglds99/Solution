package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {


    public static void main(String[] args) {
        String suffixExpression = " 2-1 + 2 ";
        String expression = "61*(5-2+6)/3+2";
        System.out.println("中缀式：  "+suffixExpression);
        List<String> list1 = InfixToList(suffixExpression);
        System.out.println("后缀式"+list1);

        List<String> list = InfixToList(expression);
        List<String> suffix = InfixToSuffix(list);
        System.out.println("后缀表达式： "+ suffix);
        int resu = calcluator(suffix);
        System.out.printf("%s=%d",expression,resu);
    }

    /**
     * 中缀转后缀表达式！
     * @param list
     * @return
     */
    public static List<String> InfixToSuffix(List<String> list) {
        Stack<String> stack1 = new Stack(); //符号栈
        //因为Stack2这个栈没有pop操作，而且后面需要逆序输出，因此比较麻烦，所以采用List结构
        List<String> s2 = new ArrayList<>(); //存储中间结果！

        for (String item : list) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                stack1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (true) {
                    if (stack1.peek().equals("(")) {
                        stack1.pop();
                        break;
                    }
                    s2.add(stack1.pop());
                }
//                while(!stack1.peek().equals("(")){
//                    s2.add(stack1.pop());
//                }
//                 stack1.pop();
            } else {
                //4遇到运算符时，比较其与s1栈顶运算符的优先级：
                //1.如果s1为空， 或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                //2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
                //3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
                while(true){
                    if (stack1.isEmpty() || stack1.peek().equals("(")) {
                        stack1.push(item);
                        break;
                    } else if (new Operation().getValue(item) >new Operation().getValue(stack1.peek())){
                        stack1.push(item);
                        break;
                    }else {
                        s2.add(stack1.pop());
                    }
                }

                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
//                while(stack1.size()!=0 &&Operation.getValue(stack1.peek()) >= Operation.getValue(item)){
//                    s2.add(stack1.pop());
//                }
//                stack1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并压入s2
        while(stack1.size() !=0){
            s2.add(stack1.pop());
        }
        return s2;
    }

    /**
     * @param expression 中缀表达式
     * @return 将中缀表达式表示成List
     */
    public static List<String> InfixToList(String expression) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str = ""; //多位数的拼接！
        char c;
        while (i < expression.length()) {
            if (((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) && (c = expression.charAt(i)) != 32) {
                list.add("" + c);
                i++;
            } else if(expression.charAt(i)==' ') {
                i++;
                continue;
            } else {
                    while (i < expression.length() && (c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57) {
                        str += c;
                        i++;
                    }
                    list.add(str);
                    str = "";
                }
            }
        return list;
    }


    public static List<String> getListString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele :
                s) {
            list.add(ele);
        }
        return list;
    }

    public static int calcluator(List<String> list) {
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            if (item.matches("\\d+")) { //匹配的是多位数
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int resu;
                if (item.equals("+")) {
                    resu = num1 + num2;
                } else if (item.equals("-")) {
                    resu = num1 - num2;
                } else if (item.equals("*")) {
                    resu = num1 * num2;
                } else if (item.equals("/")) {
                    resu = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误！");
                }
                stack.push("" + resu);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int resu = 0;
        switch (operation) {
            case "+":
                resu = ADD;
                break;
            case "-":
                resu = SUB;
                break;
            case "*":
                resu = MUL;
                break;
            case "/":
                resu = DIV;
                break;
            default:
                break;
        }
        return  resu;
    }
}