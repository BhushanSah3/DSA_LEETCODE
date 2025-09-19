class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowzero = false, colzero = false;
        int n = matrix.length;
        int m = matrix[0].length;

        // 1. Check first row
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                rowzero = true;
                break;
            }
        }

        // 2. Check first column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                colzero = true;
                break;
            }
        }

        // 3. Mark rows & cols
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4. Update cells
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5. Handle first row
        if (rowzero) {
            for (int j = 0; j < m; j++) matrix[0][j] = 0;
        }

        // 6. Handle first col
        if (colzero) {
            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        }
    }
}
