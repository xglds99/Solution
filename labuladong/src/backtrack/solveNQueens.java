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
        // ���߽�����������
        if (row == board.length) {
            List<String> result = new ArrayList<>();
            for (char[] chars : board) {
                result.add(String.valueOf(chars));
            }
            res.add(result);
            return;
        }

        // ��ѡ��
        int cols = board[0].length;
        for (int col = 0; col < cols; ++col) {
            if (valid(board, row, col)) {
                // ѡ��
                board[row][col] = 'Q';
                // ��һ�����
                backTrack(board, row + 1);
                // ����ѡ��
                board[row][col] = '.';
            }
        }
    }

    public boolean valid(char[][] board, int row, int col) {
        int cols = board[0].length;
        // �������Ƿ�Ϸ�
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // ���Ϸ��Ƿ�Ϸ�
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // ���Ϸ��Ƿ�Ϸ�
        for (int i = row - 1, j = col + 1; i >= 0 && j < cols; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
