package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static class Pair{
        int node,wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        int dist[]=new int[v];
        Arrays.fill(dist,(int)(1e9));
        dist[s]=0;
        PriorityQueue <Pair> pq= new PriorityQueue<>((a,b) -> a.wt-b.wt);
        pq.add(new Pair(s,0));
        while (!pq.isEmpty()){
            int node=pq.peek().node;
            int wt=pq.peek().wt;
            pq.poll();
            if(dist[node]==(int)(1e9)){
                continue;
            }

            for(ArrayList<Integer> i : adj.get(node)){
                int neigh=i.get(0);
                int w=i.get(1);
                if(dist[neigh] > dist[node]+w){
                    dist[neigh] = dist[node]+w;
                    pq.add(new Pair(neigh,dist[neigh]));
                }
            }
        }

        return dist;
        // Write your code here
    }
}
