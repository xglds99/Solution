package bitoperation.xgl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class l260 {

    public static void main(String[] args) {
        int x = 6;

        System.out.println(x & (-x));
    }

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream intStream = Arrays.stream(nums).map(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        return new int[]{1, 2};
    }

}
