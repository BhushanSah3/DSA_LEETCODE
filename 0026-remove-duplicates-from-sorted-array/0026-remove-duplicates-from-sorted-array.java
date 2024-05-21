class Solution {
    public int removeDuplicates(int[] arr) {
        int count=1;
        int i=0;
        if (arr.length == 0) return 0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
                count++;
            }
        }
        return count;
    }
}