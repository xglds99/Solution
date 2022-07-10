
import java.text.DecimalFormat;
import java.util.Deque;
import java.util.LinkedList;


public class l682calPoints {
    public static void main(String[] args) {
        String []ops=new String[]{"5","2","C","D","+"};
        System.out.println(new l682calPoints().calPoints(ops));
    }

    public int calPoints(String [] ops){
        Deque<String> deque=new LinkedList<>();
        int resu=0;
        for(int i=0 ; i< ops.length ; i++){
            if(ops[i].equals("C")){
                deque.pop();
            }else if(ops[i].equals("D")){
                int num=Integer.parseInt(deque.peek());
                num=num*2;
                deque.push(Integer.toString(num));
            }else if(ops[i].equals("+")){
                int num1=Integer.parseInt(deque.pop());
                int num2=Integer.parseInt(deque.peek());
                deque.push(Integer.toString(num1));
                deque.push(Integer.toString(num1+num2));
            }else{
                deque.push(ops[i]);
            }
        }
        while(!deque.isEmpty()){
            resu+=Integer.parseInt(deque.pop());
        }
        return resu;
    }
}
