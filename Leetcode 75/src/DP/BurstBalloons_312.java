package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr=new ArrayList();
        arr.add(1);
        Arrays.stream(nums).forEach(i -> arr.add(i));
        arr.add(1);
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i,-1));
        return dfs(1,nums.length, dp, arr);

    }
    private int dfs(int i, int n, int[][] dp, ArrayList<Integer> arr){
        if(i>n){
            return 0;
        }
        if(dp[i][n] != -1){
            return dp[i][n];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=n;k++){
            int sum=arr.get(i-1)*arr.get(k)*arr.get(n+1);
            ans=Math.min(ans, sum+dfs(i,k-1,dp,arr)+dfs(k+1,n,dp,arr));
        }
        return dp[i][n]=ans;

    }
}
