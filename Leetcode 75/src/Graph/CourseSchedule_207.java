package Graph;

import java.util.ArrayList;

public class CourseSchedule_207 {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int a[] :prerequisites ){
            adj.get(a[0]).add(a[1]);
        }

        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,vis,new boolean[n], adj)){
                    return false;
                }
            }
        }
        return true;

    }

    private boolean dfs(int node, boolean[] vis, boolean[] rstack, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=true;
        rstack[node]=true;

        for (int neigh : adj.get(node)){
            if(!vis[neigh]){
                if(dfs(neigh,vis,rstack,adj)){
                    return true;
                }
            }
            else if(rstack[neigh]){
                return true;
            }
        }
        rstack[node]=true;

        return false;
    }
}
