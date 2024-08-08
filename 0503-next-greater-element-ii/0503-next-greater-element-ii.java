class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int  n=nums.length;
        int nge[] = new int[n];
        for (int i = 0; i < n ; i++) {
             nge[i] = -1; // Initialize nge array with -1 in case if there is not 
            for (int j = i + 1; j < i + n ; j++) {
                int idx = j % n;
                if (nums[idx] > nums[i]) {
                    nge[i] = nums[idx];
                    break;                   
                }
                
            }
        }
        return nge;
    }
}