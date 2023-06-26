import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l914 {
    /**
     * ����һ���ƣ�ÿ�����϶�д��һ��������
     * ��ʱ������Ҫѡ��һ������ X��ʹ���ǿ��Խ������ư���������ֳ� 1 �������飺
     * ÿ�鶼�� X ���ơ�
     * �������е����϶�д����ͬ��������
     * �������ѡ�� X >= 2 ʱ���� true��
     * ˼·������ÿ�����ֳ��ֵĴ�����������������������С��Լ���������С��Լ��>=2����
     * �ȿ��Է��飬ÿ����X����x��������ͬ
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
       int n = deck.length;
       int []f = new int[10001];
       for (int i: deck){
           f[i]++;
       }
       int g = 0;
        for (int i = 0; i < 10001; i++) {
            g = gcd(f[i],g);
        }
        return g >= 2;
    }

    public static int gcd(int a, int b){
        if (b == 0)return a;
        return gcd(b,a % b);
    }

    public static void main(String[] args) {
        int s = gcd(2,0);
        System.out.println(s);
    }
}
