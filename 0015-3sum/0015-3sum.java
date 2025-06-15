class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(ls);
                    j++;
                    k--;
                    //these two loops for the checking if the beside elemnts are same or not 
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {  
                        k--;
                    }
                } 
                else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }

        }

        return result;

    }
}