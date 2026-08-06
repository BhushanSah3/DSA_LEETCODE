class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int curmax=nums[0];
        int curmin=nums[0];
        int max=nums[0];

        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=curmax;
                curmax=curmin;
                curmin=temp;
            }

            curmax=Math.max(nums[i], curmax*nums[i]);
            curmin =Math.min(nums[i], curmin*nums[i]);
            max=Math.max(curmax, max);
        }
        return max;
        
    }
}