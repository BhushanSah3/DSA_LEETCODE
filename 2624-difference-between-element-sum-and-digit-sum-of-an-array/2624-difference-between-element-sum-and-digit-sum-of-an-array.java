class Solution {
    public int differenceOfSum(int[] nums) {
        int sumnums = 0;
        int onesum = 0;
        for (int i = 0; i < nums.length; i++) {
            sumnums += nums[i];
             while(nums[i]>0){
                 onesum += nums[i] % 10;
                nums[i]=nums[i] / 10;
            }
        }
        return sumnums - onesum;
    }
}