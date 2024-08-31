package Graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean vis[][]=new boolean[n][m];
                if(checkPacific(i,j,n,m,Integer.MAX_VALUE,heights,new boolean[n][m]) &&
                   checkAtlantic(i,j,n,m,Integer.MAX_VALUE,heights,new boolean[n][m])
                ) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    private boolean checkAtlantic(int i, int j, int n, int m,int prev, int[][] heights, boolean[][] vis) {

        if(i < 0 || j < 0 || i>=n || j>=m || vis[i][j] || heights[i][j]>prev){
            return false;
        }
        if(i==n-1 || j==m-1){
            return true;
        }
        vis[i][j]=true;
        return  checkAtlantic(i-1,j,n,m,heights[i][j],heights,vis) ||
                checkAtlantic(i+1,j,n,m,heights[i][j],heights,vis) ||
                checkAtlantic(i,j-1,n,m,heights[i][j],heights,vis) ||
                checkAtlantic(i,j+1,n,m,heights[i][j],heights,vis) ;


    }

    private boolean checkPacific(int i, int j, int n, int m,int prev, int[][] heights, boolean[][] vis) {

        if(i < 0 || j < 0 || i>=n || j>=m || vis[i][j] || heights[i][j]>prev){
            return false;
        }
        if(i==0 || j==0){
            return true;
        }
        vis[i][j]=true;
        return  checkPacific(i-1,j,n,m,heights[i][j],heights,vis) ||
                checkPacific(i+1,j,n,m,heights[i][j],heights,vis) ||
                checkPacific(i,j-1,n,m,heights[i][j],heights,vis) ||
                checkPacific(i,j+1,n,m,heights[i][j],heights,vis) ;


    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        new PacificAtlanticWaterFlow_417().pacificAtlantic(array);
    }
}
