package ArraysAndHashing;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public int solve(int[][] arr) {
        int n=arr.length;
       int start[]=new int[n];
       int end[]=new int[n];
       for(int i=0;i<n;i++){
           start[i]=arr[i][0];
           end[i]=arr[i][1];
       }
       Arrays.sort(start);
       Arrays.sort(end);
        int i=0,j=0;
        int room=1,ans=0;
        while(i<n){
            if(start[i]<=end[j]){
                i++;
                room++;
            }
            else if(end[j] < start[i]){
                j++;
                room--;
            }
            ans=Math.max(ans,room);

        }
        return ans;

    }

    /*

    1   2   4   5   15  18
    11  13  15  18  23  29
            [1, 18]
            [18, 23]
            [15, 29]
            [4, 15]
            [2, 11]
            [5, 13]
     */
}
