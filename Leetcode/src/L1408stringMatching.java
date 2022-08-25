import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1408stringMatching {
    public static void main(String[] args) {
    String [] words = new String[]{"mass","as","hero","superhero"};
        List<String> list = stringMatching(words);
        list.forEach(System.out::println);
        System.out.println(KMP("mass", "as"));
    }


    public static List<String> stringMatching(String[] words) {

        Arrays.sort(words);
        for (String value : words) {
            System.out.print(value + " --");
        }
        List<String> resu = new ArrayList<>();
        for (String s : words) {
            for (String word : words) {
                if (s.length() > word.length())
                    continue;
                if (KMP(word, s) != -1)
                    resu.add(s);

            }
        }
        return resu;
    }

    public static int KMP(String ts, String ps) {
        if (ts.length() < ps.length()){
            return -1;
        }

        char[] t = ts.toCharArray();

        char[] p = ps.toCharArray();

        int i = 0; // ������λ��

        int j = 0; // ģʽ����λ��

        int[] next = getNext(ps);

        while (i < t.length && j < p.length) {

            if (j == -1 || t[i] == p[j]) { // ��jΪ-1ʱ��Ҫ�ƶ�����i����ȻjҲҪ��0

                i++;

                j++;

            } else {

                // i����Ҫ������

                // i = i - j + 1;

                j = next[j]; // j�ص�ָ��λ��

            }

        }

        if (j == p.length) {

            return i - j;

        } else {

            return -1;

        }

    }

    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {

                if (p[++j] == p[++k]) { // �������ַ����ʱҪ����

                    next[j] = next[k];

                } else {

                    next[j] = k;

                }

            } else {

                k = next[k];

            }

        }

        return next;

    }


}
