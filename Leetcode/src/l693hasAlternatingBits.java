import org.junit.Test;

public class l693hasAlternatingBits {

    @Test
    public void test(){
        System.out.println(hasAlternatingBits(5));
    }


    public boolean hasAlternatingBits(int n){
        String s = Integer.toBinaryString(n);
        boolean flag=true;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
