class Solution {

    public boolean isBipartite(int[][] graph) {
        // remember the given graph is a adjancy matrix ,,Neighbors of 0: [1, 3]
        int[]  vis = new int[graph.length];
        Arrays.fill(vis, -1);
        for(int i=0;i< graph.length;i++){
            if(vis[i]==-1 && !validColor(graph, vis, i)){
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph,int[] vis ,int start){
        Queue <Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=0;
    
        while(!q.isEmpty()){
            int node =q.poll();
            int color=vis[node];

            for(int neigh: graph[node]){
                if(vis[neigh]==-1){
                    vis[neigh] = 1 - color;
                    q.add(neigh);
                }else if (vis[neigh] == color){
                    return false;
                }
            }

        }
        return true;
    }
}