class Solution {
    public int counter=1;
    //return type kya rakhe 
    public void dfs(int node, int par, int[] tin, int[] low, int[] vis,List<List<Integer>> bridges ,ArrayList<ArrayList<Integer>> ls){
        
        tin[node]=low[node]=counter;
        counter ++;
        vis[node]=1;
        for(Integer child: ls.get(node)){
            if(child==par){ 
                continue;
            }
            if(vis[child]==0){
                dfs(child, node,  tin , low, vis, bridges,ls );
                low[node]=Math.min(low[node], low[child]);

                if(low[child] > tin[node]){ //main jst logic 
                    bridges.add(Arrays.asList(child, node)); //
                }
                 
            }
            else{
                low[node]=Math.min(low[node], low[child]);

            }
            
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] vis =new int [n];
        int[] tin= new int[n];
        int[] low =new int[n];
        //just forming an adj list 
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        } 
        //putting value in adj list 
        for(List<Integer> it:connections){ //
            int u=it.get(0); //
            int v=it.get(1);
            ls.get(u).add(v);
            ls.get(v).add(u);

        }
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,tin,low,vis ,bridges,ls);
        return bridges;
        
    }
}