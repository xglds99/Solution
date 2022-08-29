public class ViolentMatch {
    public static void main(String[] args) {
        String str1 = "abcabcd";
        String str2 = "abcd";
        System.out.println(violentMatch(str1, str2));
    }


    /**
     * 判断str1是否含有str2，如果存在则返回第一次出现的位置；否则返回-1。
     * @param str1
     * @param str2
     * @return
     */
    public static int violentMatch(String str1,String str2){
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int len1 = str1.length();
        int len2 = str2.length();

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2){
            if(c1[i] == c2[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == len2){
            return i - j;
        }
        return -1;

    }
}
