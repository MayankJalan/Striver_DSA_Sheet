package ArraysAndHashing;

public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int min=prices[0],ans=0;
        for(int i: prices){
            min=Math.min(min,i);
            ans=Math.max(i-min,ans);
        }
        return ans;
    }
}
