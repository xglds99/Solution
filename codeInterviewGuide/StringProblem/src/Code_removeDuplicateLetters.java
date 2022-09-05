public class Code_removeDuplicateLetters {


    public String removeCode_removeDuplicateLetters(String s){
        char[] str = s.toCharArray();
        int []map = new int[26];
        for (char c : str) {
            map[c - 'a']++;
        }
        char []res = new char[26];
        int index = 0;
        int L = 0;
        int R = 0;
        while (R != str.length){
            if (map[str[R] - 'a'] == -1 || --map[str[R] - 'a'] > 0){
                R++;
            }
            else {
                int pick = -1;
                for (int i = 0; i <= R; i++) {
                    if (map[str[i] - 'a'] != -1 && (pick == -1 || str[i] < str[pick])){
                        pick = i;
                    }
                }
                res[index++] = str[pick];
                for (int i = 0; i <= R; i++) {
                    if (map[str[i] - 'a'] != -1){
                        map[str[i] - 'a']++;
                    }
                }
                map[str[pick] - 'a'] = -1;
                L = pick+1;
                R=  L;
            }
        }
        return String.valueOf(res,0,index);
    }
}
