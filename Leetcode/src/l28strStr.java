public class l28strStr {
    public static void main(String[] args) {
        StringBuilder  stringBuilder  =  new StringBuilder();
        StringBuffer stringBuffer  =new StringBuffer();
    }

    public  int strStr(String haystack,String needle){
        /*����ƥ���ַ���
        �ؼ��㣺��i��j��λ�ò�ƥ��ʱ��i���ݣ�j=0������i=i-j+1��
        ��ƥ�����ʱ��ֱ���ж��Ӵ��Ƿ�ƥ�䵽���һλ��
        1����������ʱ����-1
        2����needleΪ��ʱ����0
        3������ʱ���ص�һ�γ��ֵ��±�
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
