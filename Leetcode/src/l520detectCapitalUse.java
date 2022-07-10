import org.junit.Test;

public class l520detectCapitalUse {
    public static void main(String[] args) {
        String s="Google";
        System.out.println(new l520detectCapitalUse().detectCapitalUse(s));
    }


    public  boolean detectCapitalUse(String s){
        if(s.length()==1)
            return true;
        char []chars=s.toCharArray();
        if(chars[0]>=97 && chars[0]<=122){ //如果第一个是小写 ，其他必是小写
            for (int i = 1; i <s.length() ; i++) {
                if(chars[i]<97)
                    return false;
            }
        }else if(chars[0]>=65 ||chars[0]<=90){  //第一个是大写，其后全是小写或者全是大写
            for (int i = 1; i < s.length(); i++) {
                if(chars[i]>90){
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public  void test(){
        char c='Z';
        int s=c;
        System.out.println(s);
    }
}
