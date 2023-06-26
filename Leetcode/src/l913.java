public class l913 {

    public int catMouseGame(int[][] g) {
        int n = g.length;
        int[][] win = new int[2][n * n];
        // mc
        for (int i = 0; i < n; i++) {
            win[0][i] = 1;
            win[1][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            win[0][i * n + i] = 2;
            win[1][i * n + i] = 2;
        }

        while (true) {
            boolean anew = false;
            for (int m = 0; m < n; m++) {
                inner:
                for (int c = 1; c < n; c++) {
                    if (win[0][m * n + c] == 0) {
                        boolean und = false;
                        for (int e : g[m]) {
                            if (win[1][e * n + c] == 1) {
                                win[0][m * n + c] = 1;
                                anew = true;
                                continue inner;
                            }
                            if (win[1][e * n + c] == 0) {
                                und = true;
                            }
                        }
                        if (!und) {
                            win[0][m * n + c] = 2;
                            anew = true;
                        }
                    }
                }
            }
            for (int c = 1; c < n; c++) {
                inner:
                for (int m = 0; m < n; m++) {
                    if (win[1][m * n + c] == 0) {
                        boolean und = false;
                        for (int e : g[c]) {
                            if (e == 0) continue;
                            if (win[0][m * n + e] == 2) {
                                win[1][m * n + c] = 2;
                                anew = true;
                                continue inner;
                            }
                            if (win[0][m * n + e] == 0) {
                                und = true;
                            }
                        }
                        if (!und) {
                            win[1][m * n + c] = 1;
                            anew = true;
                        }
                    }
                }
            }
            if (!anew) break;
        }
        return win[0][1 * n + 2];
    }
}
