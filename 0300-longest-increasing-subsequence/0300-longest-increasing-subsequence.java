class Solution {
    public int recur(int i,int prev, int[] nums, int[][] dp){ 
        if(i==nums.length) return 0;

       if(dp[i][prev+1]!=-1) return dp[i][prev+1];

        int take=0;
        int nottake=0+ recur(i+1,prev, nums, dp);

        if(prev==-1 || nums[i]> nums[prev]){
            take= 1+ recur(i+1,i, nums, dp);
        }
         return dp[i][prev+1]= Math.max(take, nottake);

    }

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]  dp =new int[n][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return recur(0,-1, nums, dp);
    }
}