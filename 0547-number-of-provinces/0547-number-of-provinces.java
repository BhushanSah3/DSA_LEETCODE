class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis  =new boolean[isConnected.length];
        Arrays.fill(vis, false);  // we have to write false not 0
        int count =0;
        for(int i=0; i<isConnected.length;i++){
            if(vis[i]==false){
                count++;
                dfs(isConnected,i,vis);
            }
        }
        return count;
    
    }

    public void dfs(int[][] isConnected, int i, boolean[] vis){
            vis[i]=true;

            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && vis[j]==false){
                    dfs(isConnected, j, vis);
                }
                
            }

        }
}