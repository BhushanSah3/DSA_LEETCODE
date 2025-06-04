class Solution {
    public void recur(int idx,int n,List<Integer> ls,List<List<Integer>> result,int target,int[] candidates){
        
        if(target == 0) {
            result.add(new ArrayList<>(ls));
            return;
        }
       for (int i = idx; i < n; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;

            ls.add(candidates[i]);
            recur(i + 1, n, ls, result, target - candidates[i], candidates);
            ls.remove(ls.size() - 1); 
        }
    }
     
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n=candidates.length;
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> ls =new ArrayList<>();
        Arrays.sort(candidates); 
        recur(0,n,ls,result,target,candidates);
        return result;

        
    }
}