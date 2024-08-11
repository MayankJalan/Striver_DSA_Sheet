package DP;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int ans=0;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(dp[i]<dp[j] && nums[i]> nums[j]){
                    dp[i]=dp[j]+1;
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={0,1,0,3,2,3};
        new LongestIncreasingSubsequence_300().lengthOfLIS(arr);
    }
}
