package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictonary {
    public static String getAlienLanguage(String []dictionary, int k) {
        //["caa", "aaa", "aab"]
        int n=dictionary.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String wrd1=dictionary[i];
            String wrd2=dictionary[i+1];

            int min=Math.min(wrd2.length(),wrd1.length());
            for(int j=0;j<min;j++){
                char ch1=wrd1.charAt(j);
                char ch2=wrd2.charAt(j);
                if(ch1 != ch2){
                    adj.get(ch1-'a').add(ch2-'a');
                    break;
                }
            }
        }

        boolean vis[]=new boolean[k];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<k;i++){
            if(!vis[i]){
                dfs(adj,vis,stk,i);
            }
        }
        String ans="";

        while(!stk.isEmpty()){
            int i=stk.pop();
            char ch = (char) (i+'a');
            ans+= String.valueOf(ch);
        }
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stk, int node) {
        vis[node]=true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfs(adj,vis,stk,i);
            }
        }
        stk.push(node);
    }

    public static void main(String[] args) {
        String []dictionary={"caa", "aaa", "aab"};
        getAlienLanguage(dictionary,3);
    }
}
