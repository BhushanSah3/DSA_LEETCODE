class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1_000_000_007;
        Map<Integer, Integer> hm = new HashMap<>();

        // Count points per y‑coordinate
        for (int[] point : points) {
            int y = point[1];
            hm.put(y, hm.getOrDefault(y, 0) + 1);
        }

        // 2) Build list of horizontal‑segment counts (nC2)
        List<Long> segs = new ArrayList<>(hm.size());
        for (int cnt : hm.values()) {
            if (cnt >= 2) {
                segs.add( (long)cnt * (cnt - 1) / 2 );
            }
        }

        // One‑pass prefix‑sum to pair them in O(M)
        long result = 0;
        long prefix = 0;
        for (long s : segs) {
            result = (result + s * prefix % mod) % mod;
            prefix = (prefix + s) % mod;
        }

        return (int) result;
    }
}
