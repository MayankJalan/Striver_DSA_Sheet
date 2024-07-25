package ArraysAndHashing;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingAndRepeating {
    int[] findTwoElement(int arr[], int n) {
        int sum1= Arrays.stream(arr).reduce(0,(a, b) -> a^b);
        //1^2^3^3
        int sum2= IntStream.rangeClosed(1,n).reduce(0,(a,b) -> a^b );
        //1^2^3^4

        int temp= sum1^sum2;
        // 3^4

        int repeating=0;
        for(int i=0;i<n;i++ ){
            int val=arr[i];
            if(arr[Math.abs(val) -1] <0){
                repeating=Math.abs(val);
                break;
            }
            else {
                arr[Math.abs(val) -1 ]*=-1;
            }
        }

        int ans[]={repeating , temp ^ repeating};




        return ans;
        //int diff=Math.ans(sum1-sum2);
        // code here
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,3};
        new MissingAndRepeating().findTwoElement(arr,4);
    }
}
