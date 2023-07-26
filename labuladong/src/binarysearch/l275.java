package binarysearch;

/**
 * @ClassName l275
 * @Description
 * @Author xgl
 * @Date 2023/7/22 17:13
 * @Version 1.0
 */
public class l275
{
    /**
     * ����һ���������� citations ������ citations[i] ��ʾ�о��ߵĵ� i ƪ���ı����õĴ�����citations �Ѿ����� �������� �����㲢���ظ��о��ߵ� h ָ����
     * h ָ���Ķ��壺h ���������ô�������high citations����һ��������Ա�� h ָ����ָ���������� ��n ƪ�����У�
     * �ܹ��� h ƪ���ķֱ����������� h �Ρ�
     * ������Ʋ�ʵ�ֶ���ʱ�临�Ӷȵ��㷨��������⡣
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            //�����ǰ���ô���Ϊ k,�Һ�����n- mid���������ô�����>=k����ô��ǰ�����ô�������n-mid��Ҫ�ҵ�����hָ��������������Ҽ�r = mid - 1;
            if (citations[mid] >= n - mid){
                r = mid - 1;
            }else{
                //�����ǰ�����ô���k,������n-mid������ ����k< n-mid����������ĿҪ����������n-mid�Σ�����������l= mid+ 1;
                l = mid + 1;
            }
        }
        return n - l;
    }
}
