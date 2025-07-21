class Solution {
    public int dfs(int i, int j, boolean[][] vis, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        if (i >= 0 && j >= 0 && i < m && j < n && (vis[i][j] != true) && (grid[i][j] != 0)) {
            sum = grid[i][j];
            vis[i][j] = true;
            sum += dfs(i - 1, j, vis, grid);
            sum += dfs(i + 1, j, vis, grid);
            sum += dfs(i, j - 1, vis, grid);
            sum += dfs(i, j + 1, vis, grid);
        }

        return sum;

    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int sum = 0, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && vis[i][j] == false ) {

                    sum = dfs(i, j, vis, grid);
                    if (sum % k == 0) {
                        count++;
                    }
                }

            }
        }

        return count;
    }
}