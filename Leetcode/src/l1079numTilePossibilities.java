import java.util.Arrays;

public class l1079numTilePossibilities {

    static int count = 0;
    public static int numTilePossibilities(String tiles) {
        //���ظ���ĸ���Ӽ�+������Ŀ
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
            //���ģ�������֤ѡ��Ԫ�ص�ʱ��֤��ͬԪ�ص����˳�򲻱䡣
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
