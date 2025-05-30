class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (hm.containsKey(sc)) {
                if (hm.get(sc) != tc) return false;
            } else {
                if (hm.containsValue(tc)) return false;
                hm.put(sc, tc);
            }
        }

        return true;
    }
}
