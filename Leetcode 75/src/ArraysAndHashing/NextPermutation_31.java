package ArraysAndHashing;

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int n=nums.length,ind=-1;
        for(int i=0;i<n-1;i++){
            if(nums[i] <nums[i+1]){
                ind=i;
            }
        }
        if(ind==-1){
            Arrays.sort(nums);
            return;
        }
        int diff=Integer.MAX_VALUE;
        int swap=ind;
        for(int i=ind+1;i<n;i++){
            if(nums[i] - nums[ind] > 0 && diff > (nums[i] - nums[ind])){
                diff=nums[i] - nums[ind];
                swap=i;
            }
        }
        int temp=nums[ind];
        nums[ind]=nums[swap];
        nums[swap]=temp;
        Arrays.sort(nums,ind+1,n);

    }
}
