class Solution {
    public int recur(int i,int j,  ArrayList<Integer> ls, int[][] dp ){
        if(i>j) return 0;
        int maxi= Integer.MIN_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        for(int k=i ;k<=j;k++){
            int sum= ls.get(i-1)* ls.get(k)*ls.get(j+1) +recur(i,k-1,ls,dp)+ recur(k+1, j, ls, dp);

            maxi=Math.max(sum, maxi);
        }

        return dp[i][j]= maxi;

    }
    public int maxCoins(int[] nums) {

        int n=nums.length;
        int[][] dp =new int[n+2][n+2];

        for(int[] num: dp){
            Arrays.fill(num,-1);
        }

        ArrayList<Integer> ls =new ArrayList<>();
        for(int a:nums){
            ls.add(a);
        }
        
        ls.addFirst(1);
        ls.add(ls.size(),1);
        return recur(1,n, ls,dp) ;
        
    }
}