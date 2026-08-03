class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;

        int pivot =0, i=0;
        //checking 

        while(pivot<n){
            int rightsum=0;
            int leftsum=0;
            for(i=0;i<pivot;i++){
                leftsum+=nums[i];
            }

            for(int j=pivot+1;j<n;j++){
              rightsum+=nums[j];
            }
            if(leftsum==rightsum){
                return i;
            }
            pivot++;
        }
        return -1;
        

    }
}