class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n= nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0;i<n;i++){
            int check =hm.getOrDefault(nums[i],0);
            if(check>=1){
                return true;
            }
            hm.put(nums[i], check+1);
        }
        return false;
    }
}