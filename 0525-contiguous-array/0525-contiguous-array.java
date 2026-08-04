class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum=0;

        hm.put(0,-1);
        int maxlen=0;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }

            if(hm.containsKey(sum)){
                int win= i-hm.get(sum);
                maxlen=Math.max(maxlen,win);
            }else{
                hm.put(sum,i);
            }
        }
        return maxlen;
    }
}