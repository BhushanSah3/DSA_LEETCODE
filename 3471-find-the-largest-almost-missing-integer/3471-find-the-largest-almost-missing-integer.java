class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        for (int start = 0; start <= n - k; start++) {
            HashSet<Integer> hs = new HashSet<>();

            for (int i = start; i < start + k; i++) {
                hs.add(nums[i]);
            }

            for (int x : hs) {
                hm.put(x, hm.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        for (int x : hm.keySet()) {
            if (hm.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}