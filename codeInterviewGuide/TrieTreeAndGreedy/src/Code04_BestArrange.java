import java.util.Arrays;
import java.util.Comparator;

public class Code04_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Program{" +
					"start=" + start +
					", end=" + end +
					'}';
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, Comparator.comparingInt(x -> x.end));
		int result = 0;
		//从左至右遍历所有的会议
		for (Program program : programs) {
			if (start <= program.start) {
				result++;
				start = program.end;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Program[] programs = new Program[5];
		programs[0] = new Program(1,3);
		programs[1] = new Program(2,4);
		programs[2] = new Program(4,6);
		programs[3] = new Program(7,10);
		programs[4] = new Program(11,13);
		System.out.println(bestArrange(programs, 1));
	}

}
