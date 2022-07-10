import org.junit.Test;

import java.util.*;

public class l720longestWord {

    @Test
    public void test() {
        String str[] = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple", "appla"};
        System.out.println(longestWord(str));
    }

    @Test
    public void test1(){
        Integer nums[]=new Integer[]{5,4,1,4,5};
        Arrays.sort(nums, (a,b)-> a-b
                );
        System.out.println(Arrays.toString(nums));
    }

    public String longestWord(String[] strs) {
        Set<String> wordset = new HashSet();
        for (String word : strs) wordset.add(word);
        //使用lambada表达式
        Arrays.sort(strs, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        System.out.println(Arrays.toString(strs));
        for (String word : strs) {
            boolean good = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }
            if (good) return word;
        }
        return "";
    }
}
