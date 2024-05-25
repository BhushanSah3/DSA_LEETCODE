class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int one = 0;
        int maxone = 0;
        for (int  i = 0; i < nums.length; i++) {
            if (nums[i] ==  1) {
                one += 1;
            } else {
                one = 0;
            }
            if (one > maxone) {
                maxone = one;
            }
        }
        return maxone;
    }
}