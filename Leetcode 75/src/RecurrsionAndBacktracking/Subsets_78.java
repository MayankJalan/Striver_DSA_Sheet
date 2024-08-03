package RecurrsionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        dfs(nums, 0, nums.length, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int nums[], int ind, int n, ArrayList<Integer> temp ){
        ans.add(new ArrayList<Integer>(temp));

        for(int i=ind;i<n;i++){
            temp.add(nums[i]);
            dfs(nums,i+1,n,temp);
            temp.remove(temp.size()-1);
        }
    }
}
