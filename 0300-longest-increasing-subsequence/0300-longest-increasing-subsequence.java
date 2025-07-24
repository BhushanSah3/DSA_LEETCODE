class Solution {
    public int recur(int i, int prev, int[] nums, int[][] dp) {
        if (i == nums.length)
            return 0;

        if (dp[i][prev + 1] != -1)
            return dp[i][prev + 1];

        int take = 0;
        int nottake = 0 + recur(i + 1, prev, nums, dp);

        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + recur(i + 1, i, nums, dp);
        }
        return dp[i][prev + 1] = Math.max(take, nottake);

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        //int[][] dp = new int[n][n + 1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return recur(0,-1, nums, dp);

        //Tabulation
        
        // int[][] dp = new int[n + 1][n + 1];
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int prev = i - 1; prev >= -1; prev--) {

        //         int take = 0;
        //         int nottake = 0 + dp[i + 1][prev+1];

        //         if (prev == -1 || nums[i] > nums[prev]) {
        //             take = 1 + dp[i + 1][i+1];
        //         }
        //         dp[i][prev + 1] = Math.max(take, nottake);
        //     }
        // }
        // return dp[0][0];

        //BINARY SEARCH 

        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);

        for(int i=1;i<n;i++){
            if(nums[i]>ls.get(ls.size()-1)){
                ls.add(nums[i]);
            }else{
                //BINARY search hoga and we put 
                int idx=Collections.binarySearch( ls,nums[i]);

                if(idx<0){  //see notes
                    idx=-idx-1;
                }
                ls.set(idx, nums[i]);
            }
        }
        return ls.size();




    }
}