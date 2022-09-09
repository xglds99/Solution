package longestCommonPrefix;

public class Test {
    public  static  final String A="123";
    public  static  final String B ;

    static {
        B="456";
        s=A+B;
    }
    static  String s;
    public static void main(String[] args) {
        System.out.println(s.equals("123456"));
        String s= A+"456";
        System.out.println(s.equals("123456"));
    }
}
