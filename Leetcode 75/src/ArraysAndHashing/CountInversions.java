package ArraysAndHashing;

public class CountInversions {
    static long inversionCount(long arr[], int n) {
        return inversion(0,n-1,arr);
        // Your Code Here
    }

    private static long inversion(int i, int n, long[] arr) {
        if(i>=n){
            return 0;
        }
        int mid=(i+n)/2;
        long left=inversion(i,mid,arr);
        long right=inversion(mid+1,n,arr);
        return left+right+mergeBoth(i,mid+1,n,arr);
    }

    private static long mergeBoth(int left, int mid, int right, long[] arr) {
        long temp[]=new long[right-left+1];
        int i=left,j=mid,k=0;
        long ans=0;
        while( i<mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
                ans+=(mid-i);
            }
        }
        while(i<mid){
            temp[k++]=arr[i++];
        }
        while(j<= right){
            temp[k++]=arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
        return ans;

    }

    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr,arr.length));

    }


}
