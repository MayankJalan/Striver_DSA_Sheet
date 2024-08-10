package Stacks_Queues;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class NextGreaterElementI_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> stk=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            int val=nums2[i];
            while (!stk.isEmpty() && val> stk.peek() ){
                stk.pop();
            }
            if(stk.isEmpty()){
                map.put(val,-1);
            }
            else {
                map.put(val,stk.peek());
            }
            stk.push(val);
        }

        for (int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}
