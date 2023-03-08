package IntToRoman;

import org.junit.Test;

public class IntToRoman {
    public static void main(String[] args) {
        IntToRoman test = new IntToRoman();
        System.out.println(test.IntToRoman(101));
    }

    public String IntToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] sybomls = new String[]{"M", "CM", "L", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder resu = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            int value = values[i];
            String symbol = sybomls[i];
            while (num >= value) {
                num -= value;
                resu.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return resu.toString();
    }

    @Test
    public void test() {
        String[] str = new String[]{"aa", "bb", "cc", "dd"};
        for (String string : str) {
            System.out.println(string);
        }
    }
}
