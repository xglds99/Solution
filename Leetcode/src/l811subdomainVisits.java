import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l811subdomainVisits {

    public List<String> subdomainVisits(String []complains){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String str : complains) {
            int space = str.indexOf(" ");
            int count = Integer.parseInt(str.substring(0, space));
            String domin = str.substring(space + 1);
            map.put(domin, map.getOrDefault(domin,0) + count);
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '.'){
                    String subDomin = str.substring(i+ 1);
                    map.put(subDomin, map.getOrDefault(subDomin,0) + count);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getValue() + " " + entry.getKey();
            res.add(s);
        }
        return res;
    }
}
