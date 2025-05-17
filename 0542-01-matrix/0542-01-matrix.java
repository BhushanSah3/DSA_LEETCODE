import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] newmat = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] d : dirs) {
                int ni = x + d[0];
                int nj = y + d[1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && !visited[ni][nj]) {
                    newmat[ni][nj] = newmat[x][y] + 1;
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        return newmat;
    }
}
