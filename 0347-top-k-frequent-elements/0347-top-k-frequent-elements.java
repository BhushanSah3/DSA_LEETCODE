class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        //list = [ (1,3), (2,2), (3,1) ] “Make a list and put all the hashmap key-value pairs into it.”

        list.sort((a, b) -> b.getValue() - a.getValue());
        //“Sort the list so that entries with larger frequency appear first.”
        // a = (2,2)
        //b = (1,3)
        //Then:  b.getValue() - a.getValue() = 3 - 2 = 1
        //In Java sorting:
        //If result > 0 → b comes before a
        //If result < 0 → a comes before b

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;

    }
}