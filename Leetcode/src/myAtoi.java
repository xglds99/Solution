import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class myAtoi {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public  int myAtoi1(String str){
        String resu="";
        System.out.println(resu.length());
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!='-' || str.charAt(i) !='+' ||str.charAt(i)>10){
                System.out.println(str.charAt(i));
                break;
            }else {
                resu+= String.valueOf(str.charAt(i));
                System.out.println("**********");
                System.out.println(str.charAt(i));
            }
        }

        return  Integer.parseInt(resu);
    }


    @Test
    public  void mytest(){
        String s="-421";
        System.out.println(myAtoi1(s));
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "star               t";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

