class Solution {

    public void recur(int idx, int n, int[] nums, List<Integer> ls, List<List<Integer>> result) {

      
        result.add(new ArrayList<>(ls));
        

        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            ls.add(nums[i]);
            recur(i + 1, n, nums, ls, result);
            ls.remove(ls.size() - 1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        recur(0, n, nums, ls, result);
        return result;

    }
}