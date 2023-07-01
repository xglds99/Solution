package dynamicprogramming.����DP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/7/1 16:25
 */
public class l467 {
    /**
    * @Author xgl
    * @Description
     * �����ַ��� base Ϊһ�� "abcdefghijklmnopqrstuvwxyz" ���޻��Ƶ��ַ��������� base �������������ģ�
     *
     * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
     * ����һ���ַ��� s ������ͳ�Ʋ����� s ���ж��� ��ͬ�ǿ��Ӵ� Ҳ�� base �г��֡�
     * ����������26��Ӣ����ĸ�У���ÿ����ĸΪ��β��������Ӵ��ĳ��ȣ���
     * eg:��dΪ��β������Ϊ3����ô�Ӵ����� d,cd,bcd
     * ע��a��ǰһ����ĸ������z
     * ��Ϊbase��һ��ѭ�����ַ������ж������ַ��Ƿ����ڿ��� +26���26ȡģ�Ƿ����һ���ɡ�
    * @Date 16:31 2023/7/1
    * @Param [s]
    * @return int
    **/
    public int findSubstringInWraproundString(String s) {
        int []dp = new int[26];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && (c - s.charAt(i - 1)  + 26) % 26 == 1){
                k++;
            }else{
                k = 1;
            }
            dp[c - 'a'] = Math.max(k,dp[c-'a']);
        }
        return Arrays.stream(dp).sum();
    }
}
