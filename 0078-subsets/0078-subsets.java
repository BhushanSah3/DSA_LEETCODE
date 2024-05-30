class Solution {
    public void findsubsets(int[] nums, List<Integer> currentList, int i, List<List<Integer>> result) {
        // Base case
        if (i == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Yes choice (include nums[i])
        currentList.add(nums[i]);
        findsubsets(nums, currentList, i + 1, result);

        // Undo the choice for the no choice branch
        currentList.remove(currentList.size() - 1);

        // No choice (do not include nums[i])
        findsubsets(nums, currentList, i + 1, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findsubsets(nums, new ArrayList<>(), 0, result);
        return result;
    }
}