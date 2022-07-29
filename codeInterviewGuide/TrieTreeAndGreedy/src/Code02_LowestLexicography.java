import java.util.Arrays;
import java.util.Comparator;

public class Code02_LowestLexicography {

//	public static class MyComparator implements Comparator<String> {
//		@Override
//		public int compare(String a, String b) {
//			return (a + b).compareTo(b + a);
//		}
//	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, (x,y) -> (x+y).compareTo(y+x));
		StringBuilder res = new StringBuilder();
		for (String str : strs) {
			res.append(str);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));

	}

}
