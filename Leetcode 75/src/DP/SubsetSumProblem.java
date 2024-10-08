package DP;

public class SubsetSumProblem {
    static Boolean isSubsetSum(int n, int arr[], int sum){
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j<arr[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
            }
        }

        return dp[n][sum];
        // code here
    }
}
