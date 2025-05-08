class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int winlen=0;
        int  freq = 1, l = 0, r = 0;
        long total =0;

        for (r = 0; r < n; r++) {
             total +=nums[r];

            while ((long) nums[r] * (r-l+1) > total +k) { // while the condition written in copy is not valid 
                total=total -nums[l]; // we subtract as we are moving ahead the left pointer 
                l++;
            }
            freq =Math.max(r-l+1, freq);
        }
        return  freq;
    }
}