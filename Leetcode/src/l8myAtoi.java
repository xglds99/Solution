public class l8myAtoi {
    public static void main(String[] args) {
        char a = '2';
        System.out.println(Character.getNumericValue(a));
    }

    public int convert(String s){
        if (s == null && s.equals("")){
            return 0;
        }
        char[] chars = s.trim().toCharArray();
        if (!isValid(chars)){
            return 0;
        }
        boolean posi = chars[0] != '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < 1; i++) {
            cur = '0' - chars[i];
            if ((res < minq) || (res == minq && cur < minr)){
                return 0;
            }
            res = res * 10 + cur;

        }
        if (posi && res == Integer.MIN_VALUE)
            return 0;
        return posi ? -res : res;
    }

    public boolean isValid(char []chars){
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')){
            return false;
        }
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')){
            return false;
        }
        if (chars[0] == '0' && chars.length == 1){
            return false;
        }
        for (char aChar : chars) {
            if (aChar < '0' || aChar > '9') {
                return false;
            }
        }
        return true;
    }
}
