package ArraysAndHashing;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE,currSum=0;
        for(int i : nums){
            currSum+=i;
            max=Math.max(max,currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return max;

    }
}
