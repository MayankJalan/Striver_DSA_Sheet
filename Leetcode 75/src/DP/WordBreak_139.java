package DP;

import java.util.HashSet;
import java.util.List;


public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> map=new HashSet<>(wordDict);
        int n=s.length();
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
