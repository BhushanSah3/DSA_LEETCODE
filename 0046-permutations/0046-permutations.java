class Solution {
    public void recur(int idx, int n, int[] nums, int[] vis, List<List<Integer>> result, List<Integer> ls) {

        if (ls.size() == n) {
            result.add(new ArrayList<>(ls));
            return;
        }
      
        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) {
                continue;
            }
            ls.add(nums[i]);
            vis[i] = 1;
            recur(i, n, nums, vis, result, ls);
            ls.remove(ls.size()-1);
            vis[i] = 0;
        }
        

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        int[] vis = new int[n];
        Arrays.fill(vis, 0);

        recur(0, n, nums, vis, result, ls);

        return result;

    }
}