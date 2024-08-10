package BinarySearch;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MinimizeMaxDistancetoGasStation {
    public static double findSmallestMaxDist(int stations[], int k) {
        int n=stations.length;
        double low=0;
        double high=0;
        for(int i=0;i<n-1;i++){
            high=Math.max(stations[i+1]-stations[i],high);
        }
        double ans=(int)(1e9);

        while (low<=high){
            double mid=low+(high-low)/2.0;
            if(isPossible(mid,stations,k)){
                ans=mid;
                high=mid-0.000001;
            }
            else{
                low=mid+0.000001;
            }

        }
       return ans;
    }

    private static boolean isPossible(double mid, int[] stations, int k) {
        int count=0;
        for(int i=0;i<stations.length-1;i++){
            int diff=stations[i+1] - stations[i];
            if(diff>mid){

                count+=(diff/mid);

                if(count>k){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int arr[]={3,6,12,19,33,44,67,72,89,95};
        double ans=findSmallestMaxDist(arr,2);
        System.out.println(ans);
    }
}
