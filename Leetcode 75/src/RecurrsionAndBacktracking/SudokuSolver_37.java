package RecurrsionAndBacktracking;

import java.util.stream.IntStream;

public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        dfs(board);
    }

    private boolean dfs( char[][] board) {

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isSafe(board,i,j,ch)){
                            board[i][j]=ch;
                            if(dfs(board)){
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;

    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {
        for(int i=0;i<9;i++){
            if(board[row][i] == ch  ||  board[i][col] == ch){
                return false;
            }

            int r=3*(row/3)+(i/3);
            int c=3*(col/3)+(i%3);
            if(board[r][c]== ch){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

    }
}
