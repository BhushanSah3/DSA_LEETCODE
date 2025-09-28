class Solution {
    public boolean Canfinish(int[] piles, int h, int mid){
        long total=0;
        for(int pile:piles){
            total +=  Math.ceil((double) pile / mid);
        }
        if(total<=h){
            return true;
        }else{
            return false;
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxspeed =0;
        
        for(int i=0;i<piles.length;i++){
            maxspeed=Math.max(maxspeed, piles[i]);
        }

        int low=1;
        int high =maxspeed;
        int result = high; // We need a variable to store the best answer we've found so far.

        while(low<=high){
            int mid =low+(high-low)/2;

            if(Canfinish(piles,h, mid) ){
                result=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }

        return result;

    }
}