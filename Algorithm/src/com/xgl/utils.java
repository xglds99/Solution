package com.xgl;

public class utils {
    /**
     * Õ·×ªÏà³ı·¨
     *
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else return gcd(y, x % y);
    }
}
