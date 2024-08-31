package DP;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=amount;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    try {
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        return dp[n][amount];

    }

    public static void main(String[] args) {
        int arr[]={1,2,5};
        new CoinChange_322().coinChange(arr,11);
    }
}
