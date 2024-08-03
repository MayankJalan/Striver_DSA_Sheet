package RecurrsionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queen_51 {
    List<List<String>> ans;
    int []diagUp;
    int []diagDown;
    int rows[];

    public List<List<String>> solveNQueens(int n) {
        diagUp=new int[2*n+1];
        diagDown=new int[2*n+1];
        rows=new int[n];
        ans=new ArrayList<>();
        char[][] arr=new char[n][n];
        Arrays.stream(arr).forEach(a -> Arrays.fill(a,'.'));
        Arrays.fill(diagDown,-1);
        Arrays.fill(diagUp,-1);
        Arrays.fill(rows,-1);


        dfs(arr,diagUp, diagDown, rows, 0,n);
        return ans;
    }

    private void dfs(char[][] arr, int[] diagUp, int[] diagDown, int[] rows, int col, int n) {
        if(col>=n){
            List<String> temp =new ArrayList<>();
            Arrays.stream(arr).forEach(a -> temp.add(String.valueOf(a)));
            ans.add(temp);
            return ;
        }

        for(int row=0;row<n;row++){
            if(arr[row][col]=='.'){
                if(rows[row] ==-1 && diagUp[row+col]==-1 && diagDown[n-row+col-1] ==-1){

                    rows[row] = 1;
                    diagUp[row+col]=1;
                    diagDown[n-row+col-1] =1;
                    arr[row][col]='Q';

                    dfs(arr,diagUp,diagDown,rows,col+1,n);

                    rows[row] = -1;
                    diagUp[row+col]=-1;
                    diagDown[n-row+col-1] =-1;
                    arr[row][col]='.';

                }
            }

        }
    }

    public static void main(String[] args) {
        new N_Queen_51().solveNQueens(4);
    }


}
