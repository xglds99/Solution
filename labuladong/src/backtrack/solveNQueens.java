package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(board[i], '.');
        }
        backTrack(board, 0);
        return res;
    }

    public void backTrack(char[][] board, int row) {
        // 决策结束，保存结果
        if (row == board.length) {
            List<String> result = new ArrayList<>();
            for (char[] chars : board) {
                result.add(String.valueOf(chars));
            }
            res.add(result);
            return;
        }

        // 做选择
        int cols = board[0].length;
        for (int col = 0; col < cols; ++col) {
            if (valid(board, row, col)) {
                // 选择
                board[row][col] = 'Q';
                // 下一层决策
                backTrack(board, row + 1);
                // 撤销选择
                board[row][col] = '.';
            }
        }
    }

    public boolean valid(char[][] board, int row, int col) {
        int cols = board[0].length;
        // 所在列是否合法
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 左上方是否合法
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 右上方是否合法
        for (int i = row - 1, j = col + 1; i >= 0 && j < cols; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
