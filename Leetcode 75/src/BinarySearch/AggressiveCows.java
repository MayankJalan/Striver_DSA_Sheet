package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t--!=0){
            int n=in.nextInt();
            int c=in.nextInt();
            int stalls[]=new int[n];
            IntStream.range(0,n).forEach(i -> stalls[i]=in.nextInt());
            System.out.println(findMaxDistance(stalls,n,c));
        }
    }

    private static int findMaxDistance (int[] stalls, int n, int c) {
        Arrays.sort(stalls);
        int low=0;
        int high=stalls[n-1]-stalls[0];
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(checkifPossible(stalls,c,n,mid)){
                ans=mid;
                low=mid+1;
            }
            else {
                high=mid-1;
            }

        }
        return ans;
    }

    private static boolean checkifPossible(int[] stalls, int c, int n, int mid) {
        int cow=1;
        int pos=stalls[0];
        for(int i=1;i<n;i++){
            if(stalls[i]-pos >=mid){
                cow++;
                pos=stalls[i];
            }
            if(cow>=c){
                return true;
            }
        }

        return false;
    }

}
