import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName l1630
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 18:50
 * @Version 1.0
 */
public class l1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> res = new ArrayList<>();
        for(int i = 0;i < m; i++){
            int k = r[i] - l[i] + 1;
            int []sn = new int[k];
            System.arraycopy(nums,l[i],sn,0,k);
            Arrays.sort(sn);
            int d = sn[1] - sn[0];
            boolean f = true;
            for(int j = 1; j < k - 1; j++){
                if(sn[j + 1] - sn[j] != d){
                    f = false;
                    break;
                }
            }
            res.add(f);
        }
        return res;
    }
}
