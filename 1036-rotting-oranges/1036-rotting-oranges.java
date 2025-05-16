class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Add all rotten oranges to queue, count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; 

        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {
                int[] orange = q.remove();
                int r = orange[0], c = orange[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; 
                        fresh--;
                        q.add(new int[]{nr, nc});
                        rotten = true;
                    }
                }
            }

            if (rotten) {
                count++;  
            }
        }

        return fresh == 0 ? count : -1;
    }
}
