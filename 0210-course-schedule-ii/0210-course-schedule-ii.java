class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int m=prerequisites.length;
        int[] topo=new int[n];
       // int[] topo1=new int[n];
        Queue <Integer> q  = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        int[] indeg=new int[n];

        //forming graph
        for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
           adj.get(b).add(a); 
            
        }

        //calculate indeg
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indeg[it]++;
            }
        }
        //  queue
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        // work on queue
        int i=0;
        while(!q.isEmpty()){
            int node =q.remove();
            topo[i]=node;
            i++;
            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
               
            }
        }
        // if condition or empty 
        if (i == n) {
          return topo;
        }

    
        return new int[0]; 




    }
}