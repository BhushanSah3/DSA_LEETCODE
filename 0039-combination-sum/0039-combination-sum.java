class Solution {
    public void recur(int idx,int target, int[] candidates, List<Integer> ls,int n, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(ls)); 
            return ;
        }
        if(idx==n || target< 0){
            return;          
        }

        ls.add(candidates[idx]); 
        recur(idx,target-candidates[idx],candidates,ls,n,result);  
        ls.remove(ls.size() - 1);                                     
        recur(idx+1,target,candidates, ls,n,result); 
         

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        List<Integer> ls =new ArrayList<>();
        List<List<Integer>> result =new ArrayList<>();
       recur(0,target,candidates,ls,n,result);
        return result;
       
    }
}