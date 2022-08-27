public class l43multiply {
    public static void main(String[] args) {
        System.out.println(multiply("123", "2"));
    }

    public static String multiply(String str1, String str2){

        return String.valueOf(convert(str1) * convert(str2)) ;
    }

    public static long convert(String str){
        long resu = 0;
        int cur = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
             cur = c - '0';
            resu = resu * 10 + cur;
        }
        return resu;
    }
}
