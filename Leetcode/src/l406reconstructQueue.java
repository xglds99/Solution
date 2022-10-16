import java.util.Arrays;
import java.util.Comparator;

public class l406reconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        int [][]res = new int[people.length][2];
        Arrays.sort(people, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < people.length; i++){

        }

        return res;
    }


}
