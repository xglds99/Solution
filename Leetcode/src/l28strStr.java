public class l28strStr {
    public static void main(String[] args) {
        StringBuilder  stringBuilder  =  new StringBuilder();
        StringBuffer stringBuffer  =new StringBuffer();
    }

    public  int strStr(String haystack,String needle){
        /*暴力匹配字符串
        关键点：当i与j的位置不匹配时，i回溯，j=0，即：i=i-j+1；
        当匹配完成时，直接判断子串是否匹配到最后一位。
        1、当不存在时返回-1
        2、当needle为空时返回0
        3、存在时返回第一次出现的下标
         */
        if(haystack.length()==0 ||needle.length()==0)
            return  0;
        int i=0,j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }

        }
        if(j==needle.length()){
            return i-j;
        }else {
            return  -1;
        }
    }

}
