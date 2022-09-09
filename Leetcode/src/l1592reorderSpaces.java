import org.junit.Test;

public class l1592reorderSpaces {

    @Test
    public void test(){
        System.out.println(reorderSpaces(" this   is a tst "));
    }

    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        String[] split = text.trim().split("\\s+");
        int spaceLength = 0;
        int words = split.length;
        for (char aChar : chars) {
            if (aChar == 32) {
                spaceLength++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (words > 1){
            int space = spaceLength / (words - 1);
            int endSpace = spaceLength % (words - 1);
            for (int i = 0; i < split.length - 1; i++) {
                sb.append(split[i]);
                for (int j = 0; j < space; j++) {
                    sb.append(' ');
                }
            }
            sb.append(split[split.length - 1]);
            for (int i = 0; i < endSpace; i++) {
                sb.append(' ');
            }
        }else {
            for (String s : split) {
                sb.append(s);
            }
            for (int i = 0; i < spaceLength; i++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    static class Solution {
        public String reorderSpaces(String text) {
            int length = text.length();
            String[] words = text.trim().split("\\s+");
            int cntSpace = length;
            for (String word : words) {
                cntSpace -= word.length();
            }
            StringBuilder sb = new StringBuilder();
            if (words.length == 1) {
                sb.append(words[0]);
                for (int i = 0; i < cntSpace; i++) {
                    sb.append(' ');
                }
                return sb.toString();
            }
            int perSpace = cntSpace / (words.length - 1);
            int restSpace = cntSpace % (words.length - 1);
            for (int i = 0; i < words.length; i++) {
                if (i > 0) {
                    for (int j = 0; j < perSpace; j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[i]);
            }
            for (int i = 0; i < restSpace; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }
}
