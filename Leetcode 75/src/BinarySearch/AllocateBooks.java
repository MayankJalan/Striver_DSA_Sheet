package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        Collections.sort(arr);
        int low=Collections.max(arr);
        int high= arr.stream().reduce(0,(a,b) -> a+b);
        int ans=0;
        while(low <=high){
            int mid=low+(high-low)/2;
            if(checkIfPossible(arr,mid,m,n)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    private static boolean checkIfPossible(ArrayList<Integer> arr, int mid, int m, int n) {
        int student=1;
        int books=0;
        for(int s : arr){
            if(books+s >mid){
                student++;
                books=s;
            }
            else{
                books+=s;
            }
        }
        return student<=m;
    }

    public static void main(String[] args) {
        Integer a[]={1 ,17 ,14 ,9 ,15 ,9 ,14};
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(a));
        findPages(arr,7,7);
    }
}
