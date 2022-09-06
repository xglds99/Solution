import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l828uniqueLetterString {


    /**
     * ��ÿһ���ַ�i����ǰ�ҵ���ͬ���ַ�j������ҵ���ͬ���ַ�k����ǰ�ַ������ս���Ĺ����ǣ���i-j��*(k-i)��
     * ���൱�����ַ�����ƴ�ӣ����ַ���A��j��i�����У��ַ�i���׵Ĵ����ǣ�i-j���Ρ����ַ���B(k-i)���У��ַ�i���׵Ĵ����ǣ�k-i����
     * ��ô������ƴ�ӵ�ʱ���ַ�i���Ӵ���j��k���Ĺ��׾������ַ����ĳ˻������ϳ˷���ʽ����
     * @param s
     * @return
     */
    public int uniqueLetterString(String s){
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    public int uniqueLetterString_1(String s) {
        // ͳ��ÿһ���ַ��Ĺ���ֵ�����������ַ����Ӱ���Ψһ�Ӵ��� * ���ַ��ұ�Ӱ���Ψһ�Ӵ���
        int n = s.length();
        char[] chs = s.toCharArray();
        int res = 0;
        for(int i = 0; i < n; i++){
            int left = i - 1, right = i + 1;
            while(left >= 0 && chs[left] != chs[i]) left--; // �ӵ�ǰ�ַ���������������ͬ�ַ�λ��left
            while(right < n && chs[right] != chs[i]) right++; // ��������������ͬ�ַ���λ��right
            res += (i - left) * (right - i);
        }
        return res;
    }

    @Test
    public void test(){
        String s = "LIVECODE";
        System.out.println(uniqueLetterString(s));
    }
}
