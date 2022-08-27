public class Code09_NQueens {

	public static int num1(int n) {
		if (n < 1) {
			return 0;
		}
		int[] record = new int[n]; // record[i] --> i行的皇后放在了第几列
		return process1(0, record, n);
	}

	/**
	 * record[0..i-1] 任何两个皇后一定不共行，不共列，不共斜线
	 * @param i 代表当前来到第几行
	 * @param record record[0...i-1]表示之前放过的皇后
	 * @param n 代表整体一共有几行
	 * @return 摆完所有的皇后，合理的摆法
	 */
	public static int process1(int i, int[] record, int n) {
		if (i == n) {
			return 1;
		}
		int res = 0;
		for (int j = 0; j < n; j++) {
			if (isValid(record, i, j)) {
				record[i] = j;
				res += process1(i + 1, record, n);
			}
		}
		return res;
	}

	/**
	 * @param record 记录record[0...i-1]的摆法
	 * @param i 第i个皇后
	 * @param j 放在第j列
	 * @return 第i个皇后放在第j列是否有效
	 */
	public static boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			//判断是否在同一列，  判断是否在在一个斜线上 45°或135° 行号相减的绝对值 与列号相减的绝对值 相等就共斜线
			if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}

	public static int num2(int n) {
		if (n < 1 || n > 32) {
			return 0;
		}
		int upperLim = n == 32 ? -1 : (1 << n) - 1;
		return process2(upperLim, 0, 0, 0);
	}

	public static int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
		if (colLim == upperLim) {
			return 1;
		}
		int pos = 0;
		int mostRightOne = 0;
		pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		int res = 0;
		while (pos != 0) {
			mostRightOne = pos & (~pos + 1);
			pos = pos - mostRightOne;
			res += process2(upperLim, colLim | mostRightOne,
					(leftDiaLim | mostRightOne) << 1,
					(rightDiaLim | mostRightOne) >>> 1);
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 14;
		int a = ~n;
		System.out.println(a);
		long start = System.currentTimeMillis();
		System.out.println(num2(n));
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

		start = System.currentTimeMillis();
		System.out.println(num1(n));
		end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

	}
}
