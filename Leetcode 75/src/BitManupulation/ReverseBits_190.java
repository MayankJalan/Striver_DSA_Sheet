package BitManupulation;

public class ReverseBits_190 {
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0;i<32;i++){
            boolean set=(n & 1<<i) !=0;
            if(set){
                ans|= (1<<(31-i));
            }
        }

        return ans;
    }
}
