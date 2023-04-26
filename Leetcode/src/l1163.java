import java.util.TreeMap;

/**
 * @author xgl
 * @date 2023/4/25 14:12
 */
public class l1163 {
    TreeMap<String,Integer> list = new TreeMap<>();
    public String lastSubstring(String s) {

        dfs(0, s);
        return list.lastKey();
    }

    public void dfs(int start,String s){
        if(start == s.length()){
            return;
        }
        for(int i = start; i < s.length(); i++){
            list.put(s.substring(start, i + 1), 0);
            dfs(i + 1, s);
        }
    }

    public static void main(String[] args) {
        String s = "vmjtxddvzmwrjvfamgpoowncslddrkjhchqswkamnsitrcmnhn";
        System.out.println(new l1163().lastSubstring(s));
    }
}
