class Solution {
    public int recur(int i, int j , ArrayList<Integer> ls, int [][] dp){
        if( i> j) return 0;

        if(dp[i][j] !=-1) return dp[i][j];
        int min= Integer.MAX_VALUE;

        for(int k=i;k<=j;k++){
            int cut= ls.get(j+1)- ls.get(i-1) + recur(i, k-1 ,ls ,dp)+ recur( k+1, j,ls ,dp);

            min=Math.min(cut, min);
        }

        return dp[i][j]= min;

    }

    public int minCost(int n, int[] cuts) {
        int len=cuts.length;
        int[][] dp =new int[len+1][len+1];

        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i], -1);
        }

        ArrayList<Integer> ls =new ArrayList<>();
        for(int a :cuts){
            ls.add(a);
        }

        ls.add(0);
        ls.add(n);
        Collections.sort(ls);

        return recur(1,len,ls ,dp);
        
    }
}