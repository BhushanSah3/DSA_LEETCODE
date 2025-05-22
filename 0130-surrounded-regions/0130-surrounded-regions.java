class Solution {
    public void dfs(int i, int j, int[][] vis, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] == 1 || board[i][j] != 'O') {
            return;
        }

        vis[i][j] = 1;

        dfs(i - 1, j, vis, board); // up
        dfs(i + 1, j, vis, board); // down
        dfs(i, j - 1, vis, board); // left
        dfs(i, j + 1, vis, board); // right
    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, vis, board);      // left border
            if (board[i][m - 1] == 'O') dfs(i, m - 1, vis, board); // right border
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(0, j, vis, board);      // top border
            if (board[n - 1][j] == 'O') dfs(n - 1, j, vis, board); // bottom border
        }

        //flipping
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
