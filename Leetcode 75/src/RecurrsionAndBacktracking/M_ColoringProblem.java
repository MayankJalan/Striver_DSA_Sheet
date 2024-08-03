package RecurrsionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class M_ColoringProblem {
    public boolean graphColoring(boolean graph[][], int m, int n) {

        int col[]=new int[n];
        Arrays.fill(col,-1);
        return dfs(0,graph,m,n,col);
    }

    private boolean dfs(int node, boolean[][] graph, int m, int n, int col[]) {
        if(node==n){
            return true;
        }
        if(col[node] != -1 ){
            return true;
        }
        for(int c=0;c<m;c++){
            if(isSafe(node,graph,col,c)){
                col[node]=c;
                if(dfs(node+1,graph,m,n,col)){
                    return true;
                }
                col[node]=-1;

            }
        }
        return false;
    }

    private boolean isSafe(int node, boolean[][] graph, int[] col, int c) {
        for(int neigh =0;neigh<graph[node].length; neigh++){
            if(graph[node][neigh] && col[neigh] ==c){
                return false;
            }
        }
        return true;
    }
}
