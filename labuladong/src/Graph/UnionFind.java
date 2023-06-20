package Graph;

import org.junit.Test;

//public class UnionFind {
//
//    public UnionFind(int n){
//        parent = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
//        count  = n;
//    }
//    private  int []parent;
//    private  int count;
//
//    private  int find(int x){
//        if (x != parent[x]){
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//    private  void union(int x, int y){
//        int rootx = find(x);
//        int rooty = find(y);
//        if (rootx == rooty) return;
//        count--;
//        parent[rootx] = rooty;
//    }
//
//    private  int getCount(){
//        return count;
//    }
public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.rank = new int[n];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        UnionFind un = new UnionFind(10);
        un.union(0, 3);
        un.union(3, 5);
        int i = un.find(5);
        System.out.println(i);

    }

    @Test
    public void test(){
        UnionFind un = new UnionFind(10);
        un.union(0, 3);

    }
}



