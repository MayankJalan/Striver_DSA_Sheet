package DP;

public class GeeksTraining {
    public int maximumPoints(int arr[][], int n) {
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<3;j++){
                int max=0;
                if(j==0){
                    max=Math.max(arr[i+1][1],arr[i+1][2]);
                }
                else if(j==1){
                    max=Math.max(arr[i+1][0],arr[i+1][2]);
                }
                else{
                    max=Math.max(arr[i+1][1],arr[i+1][0]);
                }
                arr[i][j]+=max;
            }

        }
        int ans=0;
        for(int i=0;i<3;i++){
            ans=Math.max(ans,arr[0][i]);
        }

        return ans;
        // code here
    }
}
