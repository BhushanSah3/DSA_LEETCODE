class Solution {
    public int[] rearrangeArray(int[] arr) {
        int[] temp=new int[arr.length];
        int pos=0;
        int neg=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                temp[pos]=arr[i];
                pos+=2;
            }else{
            temp[neg]=arr[i];
            neg+=2;
            }
        }
        return temp;
    }
}