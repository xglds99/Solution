public class l521findLUSlength {
/*
���������ַ���?a?��?b���뷵�� �������ַ����� �����������? ����������ڣ��򷵻� -1?��

����������С�?�������£�������Ϊ?ĳ�ַ������е�������У��������������ַ����������У�?��

�ַ���?s?�����������ڴ�?s?��ɾ�������������ַ�����Ի�õ��ַ�����

���磬"abc" �� "aebdc" �������У���Ϊɾ�� "aebdc" ��б��Ӵֵ��ַ����Եõ� "abc" �� "aebdc" �������л����� "aebdc" �� "aeb" �� "" (���ַ���)��
?


 */
public static void main(String[] args) {
    System.out.println(new l521findLUSlength().findLUSlength("abcdes", "abcdesd"));

}

    public int findLUSlength(String a, String b) {
            if(a.equals(b)){
                return  -1;
            }else{
                return Math.max(a.length(),b.length());
            }
    }



}
