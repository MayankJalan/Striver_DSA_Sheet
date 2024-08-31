package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer> map=new HashSet<>();
        Arrays.stream(nums).forEach(a -> map.add(a));
        int ans=1;
        for(int num : map){
            int curr=1;
            if(map.contains(num-1)){
                continue;
            }
            while(map.contains(num+1)){
                curr++;
                num++;
            }
            ans=Math.max(ans,curr);

        }

        return ans;
    }
}
