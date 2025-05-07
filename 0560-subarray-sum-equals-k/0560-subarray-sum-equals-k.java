class Solution {
    public int subarraySum(int[] nums, int k) {
        int presum=0;
        int count=0;
        HashMap <Integer, Integer> mp=new HashMap<>(); 
        mp.put(0,1);

        for(int i=0; i< nums.length;i++){
            presum+=nums[i];
            int remove= presum-k;       
            //This computes the value we need to remove from the prefix sum to get a subarray sum of k.    
            count += mp.getOrDefault(remove, 0);
            mp.put(presum, mp.getOrDefault(presum, 0) + 1);

        }
        return count;
    }
}