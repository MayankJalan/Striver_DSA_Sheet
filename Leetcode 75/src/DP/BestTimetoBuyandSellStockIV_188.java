package DP;

public class BestTimetoBuyandSellStockIV_188 {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][]=new int[k+1][n];

        for(int i=1;i<=k;i++){
            for(int j=0;j<n;j++){
                int max=0;
                for(int day=0;day<j;day++){
                    max=Math.max(max,Math.max( dp[i-1][day] +prices[j]-prices[day], dp[i][j-1] ));
                }
                dp[i][j]=max;
            }
        }

        return dp[k][n-1];

    }
}
