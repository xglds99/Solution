package backtrack;

import common.TreeNode;

import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName l95
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/2 19:19
 * @Version 1.0
 */
public class l95 {


    /**
     * �����������ؼ��������Ǹ��ڵ��ֵ�������������нڵ��ֵ��С�����������нڵ��ֵ��
     * ����������������Ҳͬ��Ϊ������������������������п��еĶ�����������ʱ�򣬼��赱ǰ���г���Ϊ nnn��
     * �������ö�ٸ��ڵ��ֵΪ iii����ô���ݶ������������������ǿ���֪���������Ľڵ�ֵ�ļ���Ϊ
     * [1��i?1][1 \ldots i-1][1��i?1]���������Ľڵ�ֵ�ļ���Ϊ [i+1��n][i+1 \ldots n][i+1��n]��
     * ���������������������������ԭ������һ�����г�����С�������⣬������ǿ����뵽�û��ݵķ�������������Ŀ��
     *
     * ���Ƕ��� generateTrees(start, end) ������ʾ��ǰֵ�ļ���Ϊ [start,end][\textit{start},\textit{end}][start,end]���������� [start,end][\textit{start},\textit{end}][start,end] ���ɵ����п��еĶ������������������ĵ�˼·�����ǿ���ö�� [start,end][\textit{start},\textit{end}][start,end] �е�ֵ iii Ϊ��ǰ�����������ĸ�����ô���л���Ϊ�� [start,i?1][\textit{start},i-1][start,i?1] �� [i+1,end][i+1,\textit{end}][i+1,end] �����֡����ǵݹ�����������֣��� generateTrees(start, i - 1) �� generateTrees(i + 1, end)��������п��е��������Ϳ��е�����������ô���һ������ֻҪ�ӿ���������������ѡһ�ã��ٴӿ���������������ѡһ��ƴ�ӵ����ڵ��ϣ��������ɵĶ�����������������鼴�ɡ�
     *
     * �ݹ����ڼ�Ϊ generateTrees(1, n)������Ϊ�� start>end\textit{start}>\textit{end}start>end ��ʱ�򣬵�ǰ����������Ϊ�գ����ؿսڵ㼴�ɡ�
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> allTrees = new LinkedList<TreeNode>();
            if (start > end) {
                allTrees.add(null);
                return allTrees;
            }

            // ö�ٿ��и��ڵ�
            for (int i = start; i <= end; i++) {
                // ������п��е�����������
                List<TreeNode> leftTrees = generateTrees(start, i - 1);

                // ������п��е�����������
                List<TreeNode> rightTrees = generateTrees(i + 1, end);

                // ��������������ѡ��һ������������������������ѡ��һ����������ƴ�ӵ����ڵ���
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode currTree = new TreeNode(i);
                        currTree.left = left;
                        currTree.right = right;
                        allTrees.add(currTree);
                    }
                }
            }
            return allTrees;
        }
}
