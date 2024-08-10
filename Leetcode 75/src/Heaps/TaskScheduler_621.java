package Heaps;

import java.util.*;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        for(char ch : tasks){
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        for(char ch : map.keySet()){
            pq.add(ch);
        }
        int ans=0;
        while(!pq.isEmpty()){
            int k=n+1;
            List<Character> list =new ArrayList<>();
            while(k >0 && pq.size()>0){
                list.add(pq.poll());
                k--;
                ans++;
            }
            for(char ch : list){
                if(map.get(ch)>1){
                    pq.add(ch);
                }
                map.put(ch,map.get(ch)-1);
            }

            ans+=k;
        }
        return ans;
    }

    public static void main(String[] args) {
        char ch[]={'A','A','A','B','B','B'};
        new TaskScheduler_621().leastInterval(ch,2);
    }
}
