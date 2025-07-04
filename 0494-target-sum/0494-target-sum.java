class Solution {
    public int recur(int i, int[] nums, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        int add = recur(i + 1, nums, sum + nums[i], target);
        int subtract = recur(i + 1, nums, sum - nums[i], target);
        
        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return recur(0, nums, 0, target);
    }
}
