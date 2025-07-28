class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long curr = 0;
        
        for (int right = 0; right < nums.length; right++) {
            long target = nums[right];
            curr += target; 

            // window_size = (right - left + 1) 
            //target_sum = window_size * target
            //cost = target_sum - curr 
            // cost > k: If our required cost is more than our budget k, the window is invalid. We must shrink it by moving the left pointer forward and subtracting nums[left] from our curr sum.

            if ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
        }
        ;
        return (nums.length - 1) - left + 1;
    }
}