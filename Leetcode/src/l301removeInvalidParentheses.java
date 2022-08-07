
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
返回所有可能的结果。答案可以按 任意顺序 返回。
示例 1：

输入：s = "()())()"
输出：["(())()","()()()"]
示例 2：

输入：s = "(a)())()"
输出：["(a())()","(a)()()"]
示例 3：

输入：s = ")("
输出：[""]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class l301removeInvalidParentheses {

    public static void main(String[] args) {

    }

    public List<String>  removeInvalidParentheses(String s){
        List<String> list=new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!='('){
                stack.push(c);
            }
        }


        return list;
    }
}
