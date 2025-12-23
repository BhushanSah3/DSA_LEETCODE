class Solution {
    public int maximumSum(int[] nums) {
        List<Integer> mod0 = new ArrayList<>();
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int x : nums) {
            if (x % 3 == 0) mod0.add(x);
            else if (x % 3 == 1) mod1.add(x);
            else mod2.add(x);
        }

        Collections.sort(mod0, Collections.reverseOrder());
        Collections.sort(mod1, Collections.reverseOrder());
        Collections.sort(mod2, Collections.reverseOrder());

        int ans = 0;

        // 0 + 0 + 0
        if (mod0.size() >= 3) {
            ans = Math.max(ans, mod0.get(0) + mod0.get(1) + mod0.get(2));
        }

        // 1 + 1 + 1
        if (mod1.size() >= 3) {
            ans = Math.max(ans, mod1.get(0) + mod1.get(1) + mod1.get(2));
        }

        // 2 + 2 + 2
        if (mod2.size() >= 3) {
            ans = Math.max(ans, mod2.get(0) + mod2.get(1) + mod2.get(2));
        }

        // 0 + 1 + 2
        if (mod0.size() >= 1 && mod1.size() >= 1 && mod2.size() >= 1) {
            ans = Math.max(ans, mod0.get(0) + mod1.get(0) + mod2.get(0));
        }

        return ans;
    }
}
