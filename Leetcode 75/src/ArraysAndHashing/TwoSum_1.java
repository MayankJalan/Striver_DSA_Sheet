package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[2];
        for(int i =0; i<nums.length;i++){
            int num=nums[i];
            if(map.containsKey(target-num)){
                arr[0]=i;
                arr[1]=map.get(target-num);
                break;
            }
            else{
                map.put(num,i);
            }
        }
        return arr;
    }
}
