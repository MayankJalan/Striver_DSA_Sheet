package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Sum3_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j=i+1, k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(sum>0){
                    k--;
                }
                else if(sum <0 ){
                    j++;
                }

            }
        }
        return ans;

    }
}
