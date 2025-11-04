class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }

        HashMap<String, List<String>> hm=new HashMap<>();

        for(String s: strs){
            int[] freq=new int[26];
            for(int i=0;i<s.length();i++){
                freq[s.charAt(i)-'a']++;
            }

            // StringBuilder sb=new StringBuilder();
            // for(int i=0;i<freq.length;i++){
            //     sb.append(freq[i]).append('#');

            // }
            // String key =sb.toString();

            //we can do this dorect conversion of frqarray to astring which is intutive but using stringbuilder it says uses less memory 
            String key=Arrays.toString(freq);

            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(s);

            


        }
        return new ArrayList<>(hm.values());
        
    }
}