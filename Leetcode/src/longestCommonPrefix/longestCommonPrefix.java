package longestCommonPrefix;

import org.junit.Test;

public class longestCommonPrefix {
    @Test
    public void test(){
        String []strs=new String[]{"flower","floot","flooe"};
        System.out.println(longestCommPrefix1(strs));
    }

    public  String  longestCommPrefix1(String strs[]){
        if(strs.length==0)
            return "";
        String s=strs[0];
        for(String string :strs){
            System.out.println(string);
            while(!string.startsWith(s)){
                if(s.length()==0) return "";
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }


}
