import org.w3c.dom.Node;

import java.util.*;

public class Code01_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    /**
     * @param rest ËþµÄ±àºÅ
     * @param down
     * @param from
     * @param help
     * @param to
     */
    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            System.out.println("-------------------------");
            func(rest - 1, down - 1, help, from, to);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);

    }
/*
n = 5           1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1
move 1 from left to right
move 2 from left to mid
move 1 from right to mid
move 3 from left to right
move 1 from mid to left
move 2 from mid to right
move 1 from left to right
move 4 from left to mid
move 1 from right to mid
move 2 from right to left
move 1 from mid to left
move 3 from right to mid
move 1 from left to right
move 2 from left to mid
move 1 from right to mid
move 5 from left to right
move 1 from mid to left
move 2 from mid to right
move 1 from left to right
move 3 from mid to left
move 1 from right to mid
move 2 from right to left
move 1 from mid to left
move 4 from mid to right
move 1 from left to right
move 2 from left to mid
move 1 from right to mid
move 3 from left to right
move 1 from mid to left
move 2 from mid to right
move 1 from left to right

Process finished with exit code 0

 */
/*
n = 4
move 1 from left to mid
move 2 from left to right
move 1 from mid to right
move 3 from left to mid
move 1 from right to left
move 2 from right to mid
move 1 from left to mid
move 4 from left to right
move 1 from mid to right
move 2 from mid to left
move 1 from right to left
move 3 from mid to right
move 1 from left to mid
move 2 from left to right
move 1 from mid to right
 */
/*n = 3
move 1 from left to right
move 2 from left to mid
move 1 from right to mid
move 3 from left to right
move 1 from mid to left
move 2 from mid to right
move 1 from left to right
	 */
}
