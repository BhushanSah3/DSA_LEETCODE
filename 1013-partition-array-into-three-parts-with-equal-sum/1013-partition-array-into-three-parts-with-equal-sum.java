class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        
        if(sum%3!=0) return false;
        int target=sum/3;
        int count=0, currsum=0;
        for(int i=0;i<n;i++){
            currsum+=arr[i];
            if(currsum==target){
                count++;
                currsum=0;
            }

        }
        if(count>=3) return true;
        return false;
        

        
    }
}