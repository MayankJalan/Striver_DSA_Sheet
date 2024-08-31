package Graph;

public class NumberofIslands_200 {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' ){
                    ans++;
                    dfs(i,j,n,m,grid);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int n, int m, char[][] grid) {
        if(i<0 || j< 0 || i>=n || j>=m || grid[i][j] !='1'){
            return ;
        }
        grid[i][j]='0';
        dfs(i+1,j,n,m,grid);
        dfs(i-1,j,n,m,grid);
        dfs(i,j+1,n,m,grid);
        dfs(i,j-1,n,m,grid);

    }
}
