class Solution {
    public boolean recur(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (i >= nums.length || target < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean take = recur(i + 1, target - nums[i], nums, dp);
        boolean notTake = recur(i + 1, target, nums, dp);

        return dp[i][target] = take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (totalSum % 2 != 0) return false;
        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return recur(0, target, nums, dp);
    }
}
