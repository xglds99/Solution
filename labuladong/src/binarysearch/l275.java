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
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
     * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）
     * 总共有 h 篇论文分别被引用了至少 h 次。
     * 请你设计并实现对数时间复杂度的算法解决此问题。
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            //如果当前引用次数为 k,且后面有n- mid本数的引用次数是>=k的那么当前的引用次数就是n-mid，要找到最大的h指数，则继续向左找即r = mid - 1;
            if (citations[mid] >= n - mid){
                r = mid - 1;
            }else{
                //如果当前的引用次数k,后面有n-mid本数， 由于k< n-mid，则不满足题目要求至少引用n-mid次，继续向右找l= mid+ 1;
                l = mid + 1;
            }
        }
        return n - l;
    }
}
