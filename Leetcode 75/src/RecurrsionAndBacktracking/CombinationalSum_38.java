package RecurrsionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum_38 {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans =new ArrayList<>();
        dfs(candidates, target,0, 0 , candidates.length, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] candidates, int target,int sum, int ind, int n, ArrayList<Integer> temp) {

        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(ind >=n || sum> target){
            return;
        }
        dfs(candidates,target,sum,ind+1, n,temp);

        temp.add(candidates[ind]);
        sum+=candidates[ind];
        dfs(candidates,target,sum,ind,n,temp);
        sum-=candidates[ind];
        temp.remove(temp.size()-1);
    }}
