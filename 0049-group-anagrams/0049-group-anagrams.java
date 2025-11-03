class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }

        HashMap<String, List<String>> hm=new HashMap<>();

        for(String s: strs){
            char[] charr= s.toCharArray();
            Arrays.sort(charr);

            String sorted =new String(charr);
            hm.putIfAbsent(sorted, new ArrayList<>());
            hm.get(sorted).add(s);

            


        }
        return new ArrayList<>(hm.values());
        
    }
}