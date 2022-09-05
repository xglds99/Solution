public class Code03_convert {
    public static boolean isValidchar(char[] chas) {
        if (chas[0] != '-' && (chas[0] < '0' || chas[0] > '9'))
            return false;
        if ((chas[0] == '-' && chas.length == 1)||
                (chas[0] =='0'&& chas.length > 1))
            return false;
        for (int i = 0; i < chas.length; i++) {
            if (chas[0] < '0')
                return false;
        }
        return true;
    }
    public static int convert(String str){
        if (str==null||str.equals(""))
            return 0;
        char[] chars =str.toCharArray();
        if (!isValidchar(chars)){//if+return ¶¼²»ÓÃelse
            return 0;
        }
        boolean posi= chars[0] != '-';
        int minq=Integer.MIN_VALUE/10;
        int minr=Integer.MIN_VALUE%10;
        int res=0;
        int cur=0;
        for (int i=posi?0:1;i<chars.length;i++){
            cur='0'-chars[i];
            if (res<minq||(res==minq&&cur<minr))
            {
                return 0;
            }
            res=res*10+cur;
        }
        if (posi&&res==Integer.MIN_VALUE){
            return 0;
        }
        return posi? -res:res;
    }
}
