class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum=0;
        int n=nums.length;

        for (int i=0;i<n;i++){
            totalsum+=nums[i];
        }
        int leftsum=0, rightsum=0;

        for(int i=0;i<n;i++){
            rightsum= totalsum -nums[i]-leftsum;
            if(leftsum==rightsum){
                return i;
            }
            leftsum+=nums[i];

        }
        return -1;

    }
}