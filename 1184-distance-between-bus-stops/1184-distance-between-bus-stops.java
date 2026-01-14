class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n=distance.length;
        int sum=0, totalsum=0;
        for(int i=0;i<n;i++){
            if(i==destination){
                break;
            }
            sum+=distance[i];

        }
        for(int i=0;i<n;i++){
            totalsum+=distance[i];
        }
        return Math.min(sum, totalsum-sum);
    }
}