package ArraysAndHashing;

import java.util.Arrays;

public class ProductofArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int pref[]=new int[n];
        int suff[]=new int[n];
        int ans[]=new int[n];
        pref[0]=1;
        suff[n-1]=1;
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]*nums[i-1];
            suff[n-i-1]=suff[n-i]*nums[n-i];
        }
        for(int i=0;i<n;i++){
           ans[i]=pref[i]*suff[i];
        }

        return ans;
    }
}
