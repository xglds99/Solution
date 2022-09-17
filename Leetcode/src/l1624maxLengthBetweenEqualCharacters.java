import java.util.Arrays;

public class l1624maxLengthBetweenEqualCharacters {


    //"rimkibmvpnhlgtdkazshyilqmywn"
    public int maxLengthBetweenEqualCharacters(String s) {
        int m = s.length();
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int max = -1;
        for (int i = 0; i < m; i++) {
            int index = s.charAt(i) - 97;
            if (map[index] == -1) {
                map[index] = i;
            } else {
                max = Math.max(max, i - map[index] - 1);
            }
        }
        return max;
    }
}
