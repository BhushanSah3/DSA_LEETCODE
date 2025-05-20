class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int i=0;
        int n=nums.length;
        List<Integer> ls =new ArrayList<>(); 
        List<List<Integer>> result =new ArrayList<>();
        print(i,ls,n, nums, result );
        return result;
        
    }
    public void print(int i, List<Integer> ls,int n, int[] nums, List<List<Integer>> result){
        if(i>=n){
            result.add(new ArrayList<>(ls));  // here understand  It means you're adding a copy of the current list ls into the final result list.
            return;
        }
        ls.add(nums[i]);
        print(i+1, ls,n,nums, result); 
        ls.remove(ls.size()-1);                // here understand why size , coz this will ensure the last one is removed of the total size
        print(i+1, ls,n,nums, result);

    }
}