package Graph;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    static class Pair{
        int node,wt;
        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    static int spanningTree(int v, int e, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.wt-b.wt);
        pq.add((new Pair(0,0)));
        int ans=0;
        boolean vis[]=new boolean[v];
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(vis[p.node]){
                continue;
            }
            vis[p.node]=true;
            ans+= p.wt;
            for(int[] i : adj.get(p.node)){
                int node=i[0];
                int node_wt=i[1];
                if(!vis[node]){
                    pq.add(new Pair(node,node_wt));
                }
            }




        }

        return ans;

        // Code Here.
    }
}
