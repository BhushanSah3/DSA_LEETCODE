class Solution {
    public boolean recur(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean take = recur(i + 1, target - nums[i], nums, dp);
        boolean notTake = recur(i + 1, target, nums, dp);

        //return dp[i][target] = take || notTake;
        boolean result = take || notTake;
        dp[i][target] = result;
        return result;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n=nums.length;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;

        Boolean[][] dp1 = new Boolean[n+1][target + 1]; // for memoization as null is valid 
       
        boolean[][] dp2 = new boolean[n + 1][target + 1];
       // return recur(0, target, nums, dp1);

        for(int i=0;i<=n;i++){
            dp2[i][0]=true;
        }

        for(int i=n-1;i>=0;i--){
            for(int t=0;t<=target;t++){
                
                boolean notTake = dp2[i + 1][t];
                boolean take=false;

                if(t>=nums[i]){
                    take = dp2[i + 1][ t - nums[i]];
                }
                dp2[i][t] = take || notTake;
            }

        }
        return dp2[0][target];



    }
}
