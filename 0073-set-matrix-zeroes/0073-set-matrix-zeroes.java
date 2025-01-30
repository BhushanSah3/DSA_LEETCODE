class Solution {
    public void setZeroes(int[][] matrix) {
        int i, j;
        int[] row=new int[matrix.length];
        int[] colm=new int[matrix[0].length];

        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {  
                if (matrix[i][j] == 0 || matrix[i][j]==0) {
                        row[i]=1;
                        colm[j]=1;
                    }
                }
            }
        for( i = 0 ;i<matrix.length;i++){
            for (j = 0; j < matrix[0].length; j++) {  
                if (row[i]==1 || colm[j]==1) {
                    matrix[i][j] = 0;
                }
            }
        }
}}