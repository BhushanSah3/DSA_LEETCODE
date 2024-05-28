class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0; // If the array is empty
        }

        Set<Integer> set = new HashSet<>();
       
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int longest = 0; 

        // Find the longest sequence
        for (int num : set) {
            // Check if 'num' is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers starting from 'num'
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest sequence length
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}