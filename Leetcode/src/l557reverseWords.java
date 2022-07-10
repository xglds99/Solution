import org.junit.Test;

public class l557reverseWords {
    public static void main(String[] args) {
    String S="Let's take LeetCode contest";
    new l557reverseWords().reverseWords(S);
    }
    @Test
    public  void test(){
        String s="Let's take LeetCode contest";
        String [] str=s.split(" ");
        for(String str1:str){
            System.out.print(str1);
            System.out.println("");
        }
    }
    public  void reverseWords(String s){
    String[] str=s.split(" ");

    for(int i=0;i< str.length;i++){
        char[] chars = str[i].toCharArray();
        reverseString(chars);
        for (char c:chars){
            System.out.print(c+"");
        }
        System.out.println();
    }
    }
    public  void reverseString(char []s){
        int low=0,high=s.length-1;
        while(low<=high){
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
}
