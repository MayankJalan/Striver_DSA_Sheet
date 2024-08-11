package DP;

import java.util.Arrays;

public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {

        int ans=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int n=s.length;
        for(int i=0;i<g.length;i++){
            while(j<n && s[j] < g[i]){
                j++;
            }
            if(j<n){
                j++;
                ans++;
            }
            else{
                break;
            }
        }

        return ans;

    }
}
