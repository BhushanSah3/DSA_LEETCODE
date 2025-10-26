class Solution {
    public boolean recur(char[][] board, String word, boolean[][] check, int i, int j, int index) {
        int m = board.length;
        int n = board[0].length;

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n || check[i][j]==true || board[i][j] != word.charAt(index)) {
            return false;
        }

        check[i][j] = true;

        boolean found =
            recur(board, word, check, i + 1, j, index + 1) ||
            recur(board, word, check, i - 1, j, index + 1) ||
            recur(board, word, check, i, j + 1, index + 1) ||
            recur(board, word, check, i, j - 1, index + 1);

        check[i][j] = false;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recur(board, word, check, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
