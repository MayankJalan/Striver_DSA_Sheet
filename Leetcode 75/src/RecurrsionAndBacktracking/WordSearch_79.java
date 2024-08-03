package RecurrsionAndBacktracking;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i,j,n,m,board,word, new boolean[n][m])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int n, int m, char[][] board, String word, boolean[][] vis) {
        if(word.length()==0){
            return true;
        }
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || word.charAt(0) != board[i][j]){
            return false;
        }

        vis[i][j]=true;
        if(
        dfs(i+1,j,n,m,board,word.substring(1),vis) ||
        dfs(i-1,j,n,m,board,word.substring(1),vis) ||
        dfs(i,j+1,n,m,board,word.substring(1),vis) ||
        dfs(i,j-1,n,m,board,word.substring(1),vis) ){
            return true;
        }
        vis[i][j]=false;
        return false;


    }
}
