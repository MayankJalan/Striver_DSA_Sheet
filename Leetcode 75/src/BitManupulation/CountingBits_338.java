package BitManupulation;

import java.util.stream.IntStream;

public class CountingBits_338 {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        ans[0]=0;
        IntStream.rangeClosed(1,n).forEach(i -> ans[i]=findSetBit(i));


        return ans;


    }

    private int findSetBit(int n) {
        int ans=0;
        for(int i =0;i<=31; i++){
            if((n & (1 << i)) !=0 ){
                ans++;
            }
        }
        return ans;
    }
}
