package romanToInt;

public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt test=new RomanToInt();
        String s="LIX";
        System.out.println(test.RomanToInt(s));
    }


  public     int RomanToInt(String s){
        int sum=0;
        int preNum=getValues(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num=getValues(s.charAt(i));
            if(preNum <num){
                sum-=preNum;
            }
            else{
                sum +=preNum;
            }
            preNum=num;
        }
        sum+=preNum;
        return  sum;
    }


   int getValues(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default: return 0;
        }
    }
}
