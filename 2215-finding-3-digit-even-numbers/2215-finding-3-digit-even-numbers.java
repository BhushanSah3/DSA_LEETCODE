class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; 
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) { 
                        set.add(num); 
                    }
                }
            }
        }

        // sort
        List<Integer> resultList = new ArrayList<>(set); /// yidhar set ka sabhi element copied to resultlist
        Collections.sort(resultList);
        int[] result = new int[resultList.size()];  // naya array banaya
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

//        hashset (set)->list( result list)-> array(result)
    }
}
