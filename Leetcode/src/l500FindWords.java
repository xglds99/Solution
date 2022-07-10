public class l500FindWords {
    public String []findWords(String words[]){
        int length = words.length;
        int resu=0;
        String []ans=new String[length];
        boolean isValid = true;
        String rowIdx = "12210111011122000010020202";
        for(String word:words) {
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                ans[resu++]=word;
            }
        }
        return  ans;
    }
}
