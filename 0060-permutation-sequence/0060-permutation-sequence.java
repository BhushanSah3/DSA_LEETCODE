class Solution {
    public String getPermutation(int n, int k) {
        int fact =1;
        List <Integer> numbers =new ArrayList<>();
        for(int i=1; i<n;i++){
          
            fact =fact*i;
             numbers.add(i);
        }
        numbers.add(n);  // ?? coz here we will be storing the final number i.e 4 here 
        String ans="";
        k=k-1;
        while(true){
            ans=ans+numbers.get(k/fact);   // just getting the number from the list which number the modulo number which is divided by the fractorial , written below 
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k=k%fact;
            fact =fact /numbers.size();

        }
        return ans;
    }
}