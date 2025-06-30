class Solution {
    public int recur(int[] tempnums){   
        int n=tempnums.length;
        int[] dp =new int[n];
        if (n == 0) return 0;
        if (n == 1) return tempnums[0];
        dp[0]=tempnums[0];
        dp[1]=Math.max(tempnums[0], tempnums[1]);

        for(int i=2;i<n;i++){
            int pick=tempnums[i]+dp[i-2];
            int notpick= dp[i-1];
            dp[i]= Math.max(pick, notpick);
        }
        return dp[n-1];

    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];
        int[] temp1=Arrays.copyOfRange(nums,0,n-1);
        int[] temp2=Arrays.copyOfRange(nums,1,n);
        int max1=recur(temp1);
       int max2= recur(temp2);
        return Math.max(max1, max2);
    }
}