package Trie;

import java.util.Arrays;

public class MaximumXORWithanElementFromArray_1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n=queries.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int max=queries[i][0];
            int num=queries[i][1];
            for(int x : nums){
                if(x>=num){
                    break;
                }


            }

        }
    }
}
