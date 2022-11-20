import java.util.Arrays;

public class l1079numTilePossibilities {

    static int count = 0;
    public static int numTilePossibilities(String tiles) {
        //有重复字母的子集+排列数目
        char []chars = tiles.toCharArray();
        int n = tiles.length();
        Arrays.sort(chars);
        boolean []used = new boolean[n];
        Arrays.fill(used,false);
        dfs(chars,used);
        return count;
    }

    public static void dfs(char []chars,boolean []used){
        for(int i = 0; i < chars.length; i++){
            //核心：用来保证选择元素的时候保证相同元素的相对顺序不变。
            if( i > 0 && chars[i - 1] == chars[i] && !used[i - 1])continue;
            if(!used[i]){
                used[i] = true;
                count++;
                dfs(chars,used);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }
}
