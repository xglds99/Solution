import java.util.HashMap;
import java.util.Map;

public class l1640canFormArray {
    /**
     * £ºarr = [91,4,64,78], pieces = [[78],[4,64],[91]]
     *
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        for (int j = 0; j < arr.length; j++) {
            if (!map.containsKey(arr[j])) {
                return false;
            }
            int index = map.get(arr[j]);
            for (int i = 0; i < pieces[index].length; i++) {
                if (arr[j + i] != pieces[index][i]) {
                    return false;
                }
            }
            j += pieces[index].length - 1;
        }
        return true;
    }

    public boolean canFormArray_1(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length; i++) {
            int idx = findIdx(arr[i], pieces);
            if (idx == -1) {
                return false;
            }
            for (int j = 0; j < pieces[idx].length; j++) {
                if (pieces[idx][j] != arr[i + j]) {
                    return false;
                }
            }
            i += pieces[idx].length - 1;
        }
        return true;
    }

    int findIdx(int a, int[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            if (a == pieces[i][0]) {
                return i;
            }
        }
        return -1;
    }


    public boolean canFormArray_2(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        for (int i = 0; i < arr.length; ) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] array = map.get(arr[i]);
            for (int j = 0; j < array.length; j++, i++) {
                if (arr[i] != array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
