import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l2100goodDaysToRobBank {


    @Test
    public  void test(){
        int [] security=new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8};
        List<Integer> list = goodDaysToRobBank(security, 2);
        for(int resu :list){
            System.out.println(resu);
        }
    }

    public List<Integer> goodDaysToRobBank(int [] security,int time){
        boolean flag1=true;
        boolean flag2=true;
        List<Integer> resu=new ArrayList<>();
        if(time== 1 || time> security.length)
            return resu;
        for (int i = 0; i < security.length; i++) {
            flag1=true;
            flag2=true;
            if((i-time)>=0 && (i+time)<security.length){  //满足前后各有time天
                for(int j=i-time;j<i;j++){
                    if ((security[j] - security[j + 1]) < 0) {
                        flag1 = false;
                        break;
                    }
                }
                for (int k=i;k<i+time;k++){
                    if ((security[k] - security[k + 1]) > 0) {
                        flag2 = false;
                        break;
                    }
                }
            if(flag1 && flag2){
                resu.add(i);
            }
        } }
        return resu;
    }
}
