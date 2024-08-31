package DP;

import java.util.Arrays;

public class HouseRobberII_213 {
    public int rob(int[] nums) {

        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int n1=help(Arrays.copyOfRange(nums,0,n-1));
        int n2=help(Arrays.copyOfRange(nums,1,n));
        return Math.max(n1,n2);
    }

    private int help(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i-2<0){
                dp[i]=Math.max(nums[i],dp[i-1]);
                continue;
            }
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int arr[]={2,3,3};
        new HouseRobberII_213().rob(arr);
    }
}
