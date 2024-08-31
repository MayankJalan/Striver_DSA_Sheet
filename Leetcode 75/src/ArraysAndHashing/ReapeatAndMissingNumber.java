package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ReapeatAndMissingNumber {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int xor= IntStream.range(1,n+1).reduce(0,(i,j) -> i ^ j );
        int xor1=0;
        for(int i=0;i<n;i++){
            xor1^=arr.get(i);
        }

        int xor2=xor1 ^ xor;
        int rightBit= xor2 & (-xor2);
        int left=0,right=0;
        for(int i : arr){
            if((rightBit & i) ==0){
                left^=i;
            }
            else{
                right^=i;
            }
        }
        for(int i=1;i<=n;i++){
            if((rightBit & i) ==0){
                left^=i;
            }
            else{
                right^=i;
            }
        }
        int temp[]={left, right};
        return temp;
    }
}
