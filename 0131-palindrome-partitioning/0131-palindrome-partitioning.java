class Solution {
    public void parti(int idx ,String s, List<String> ls, List<List<String>> result) {
        if(idx==s.length()){
            result.add(new ArrayList<>(ls));
            return ;
        }
        for (int i=idx; i<s.length();i++){
            if(isvalid(s,idx,i)){
                ls.add(s.substring(idx, i+1));
                parti(i+1, s, ls, result);
                ls.remove(ls.size()-1);
            }
        }
        
    }
    public boolean isvalid(String pal,int i, int j){
        int n= pal.length();
        char[] str = pal.toCharArray();
        while(i<j){
            if(str[i]!=str[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        parti(0,s, ls, result);

        return result;

    }
}