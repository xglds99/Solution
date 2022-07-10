package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {


    public static void main(String[] args) {
        String suffixExpression = " 2-1 + 2 ";
        String expression = "61*(5-2+6)/3+2";
        System.out.println("��׺ʽ��  "+suffixExpression);
        List<String> list1 = InfixToList(suffixExpression);
        System.out.println("��׺ʽ"+list1);

        List<String> list = InfixToList(expression);
        List<String> suffix = InfixToSuffix(list);
        System.out.println("��׺���ʽ�� "+ suffix);
        int resu = calcluator(suffix);
        System.out.printf("%s=%d",expression,resu);
    }

    /**
     * ��׺ת��׺���ʽ��
     * @param list
     * @return
     */
    public static List<String> InfixToSuffix(List<String> list) {
        Stack<String> stack1 = new Stack(); //����ջ
        //��ΪStack2���ջû��pop���������Һ�����Ҫ�����������˱Ƚ��鷳�����Բ���List�ṹ
        List<String> s2 = new ArrayList<>(); //�洢�м�����

        for (String item : list) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                stack1.push(item);
            } else if (item.equals(")")) {
                //����������š�)���������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
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
                //4���������ʱ���Ƚ�����s1ջ������������ȼ���
                //1.���s1Ϊ�գ� ��ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ��
                //2.���������ȼ���ջ��������ĸߣ�Ҳ�������ѹ��s1��
                //3.���򣬽�s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚϣ�
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

                //��item�����ȼ�С�ڵ���s1ջ�������, ��s1ջ������������������뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚ�
//                while(stack1.size()!=0 &&Operation.getValue(stack1.peek()) >= Operation.getValue(item)){
//                    s2.add(stack1.pop());
//                }
//                stack1.push(item);
            }
        }
        //��s1��ʣ�����������ε�����ѹ��s2
        while(stack1.size() !=0){
            s2.add(stack1.pop());
        }
        return s2;
    }

    /**
     * @param expression ��׺���ʽ
     * @return ����׺���ʽ��ʾ��List
     */
    public static List<String> InfixToList(String expression) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str = ""; //��λ����ƴ�ӣ�
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
            if (item.matches("\\d+")) { //ƥ����Ƕ�λ��
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
                    throw new RuntimeException("���������");
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