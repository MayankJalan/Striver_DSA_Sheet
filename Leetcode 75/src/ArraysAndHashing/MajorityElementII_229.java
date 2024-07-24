package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;

        ArrayList<Integer> ans=new ArrayList<>();

        int candidate1=-1;
        int candidate2=-1;
        int count1=0, count2=0;

        for(int i : nums){
            if(i == candidate2){
                count2++;
            }
            else if(i== candidate1){
                count1++;
            }
            else if(count1 ==0 && i != candidate2){
                candidate1=i;
                count1++;

            }
            else if(count2 ==0 && i != candidate1){
                candidate2=i;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for (int i : nums){
            if(i == candidate1){
                count1++;
            }
            else if(i==candidate2){
                count2++;
            }
        }
        if(count1>(n/3)){
            ans.add(candidate1);
        }
        if(count2>(n/3)){
            ans.add(candidate2);
        }
        Collections.sort(ans);
        return ans;

    }
}
