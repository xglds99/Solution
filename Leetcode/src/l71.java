import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xgl
 * @date 2023/6/27 18:34
 */
public class l71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for(String dir : paths) {
            if (dir.equals("..")){
                if (!deque.isEmpty()){
                    deque.poll();
                }
            }else if(dir.length() > 0 && !dir.equals(".")){
                deque.offerLast(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()){
            sb.append("/");
        }else{
            while(!deque.isEmpty()){
                sb.append("/");
                sb.append(deque.pollFirst());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "/a//b////c/d//././/..";
        String[] sp = s.split("/");
       for(var ss: sp){
           System.out.println(ss);
       }

    }

}
