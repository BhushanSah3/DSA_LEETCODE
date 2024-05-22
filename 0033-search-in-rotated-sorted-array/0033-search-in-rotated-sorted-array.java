class Solution {
    public int find (int arr[],int  tar, int si, int ei){
        int mid=(si+(ei-si)/2);

        //base case
        if(si>ei){
            return -1;
        }

        if(tar==arr[mid]){
            return mid;
        } 
        // Determine which side is properly sorted
         //lie on l1 line
        if(arr[si]<=arr[mid]){
             //case a only left
             if(arr[si]<=tar && tar<=arr[mid]){
               return find(arr,tar,si,mid-1);
             }// case b   whole right
             else{
               return find(arr,tar,mid+1,ei);
             }    
        }
        // in Line 2
        else{
            // case c right
            if(arr[mid]< tar && tar<=arr[ei]){
                return find(arr,tar,mid+1,ei);
            }else{
                // case d whole left side
                return find(arr,tar,si,mid-1); 
            }

        }
    }

    public int search(int[] arr, int tar) {
        int si = 0;
        int ei = arr.length - 1;
        int targetindex=find(arr,tar,si,ei);
        return targetindex;
    }
}