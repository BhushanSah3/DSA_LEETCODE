class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if (m!=n) return false;

        HashMap<Character, Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        for(int j=0;j<m;j++){
            hm.put(t.charAt(j),hm.getOrDefault(t.charAt(j),0)-1);
            if (hm.get(t.charAt(j)) == 0) {
                hm.remove(t.charAt(j));
            }
        }

        if(!hm.isEmpty()){
            return false;
        }
        return true;
        
    }
}