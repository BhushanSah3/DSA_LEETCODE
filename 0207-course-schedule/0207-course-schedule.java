class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q=new LinkedList<>();
        int n=prerequisites.length;
        ArrayList<Integer> topo =new ArrayList<>();
        int[] indeg =new int[numCourses];

        // forming graph
       ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        } 
        for(int i=0;i<n;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        //finding indegree
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indeg[it]++;
            }
        }
        // queue
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        //topo
        while(!q.isEmpty()){
            int node=q.remove();
            topo.add(node);
            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }

        }
        //bool work
        if(topo.size()== numCourses){
            return true;
        }
        return false;

        
    }
}