public class l28strStr {
    public static void main(String[] args) {
        StringBuilder  stringBuilder  =  new StringBuilder();
        StringBuffer stringBuffer  =new StringBuffer();
    }

    public  int strStr(String haystack,String needle){
        /*????????????
        ???????i??j??��?��???????i?????j=0??????i=i-j+1??
        ???????????????��??????????????��??
        1???????????????-1
        2????needle????????0
        3??????????????��?????��?
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
