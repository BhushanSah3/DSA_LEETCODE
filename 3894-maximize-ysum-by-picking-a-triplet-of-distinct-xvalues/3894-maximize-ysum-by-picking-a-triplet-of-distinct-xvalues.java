class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int result=0;

        for(int i=0;i<x.length;i++){
            hm.put(x[i], Math.max(hm.getOrDefault(x[i],0), y[i]) );
        }
        if(hm.size()<3){
            return -1;
        }
        for(int val:hm.values()){
            pq.add(val);
        }
        for(int i=0;i<3;i++){
            result+=pq.poll();
        }
        return result;


        
    }
}