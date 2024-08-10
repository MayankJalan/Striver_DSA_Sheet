package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops_787 {
    class Pair{
        int node,wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    class Trio{
        int node, dist,stops;

        public Trio(int node, int dist,int stops) {
            this.node = node;
            this.dist = dist;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i [] : flights){
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        }
        Queue<Trio> q=new LinkedList<>();
        q.add(new Trio(src,0,0));
        int distance[]=new int[n];
        Arrays.fill(distance,(int) 1e9);
        distance[src]=0;
        while (!q.isEmpty()){
            int node=q.peek().node;
            int dist=q.peek().dist;
            int stops=q.peek().stops;
            q.poll();
            if(stops>k){
                continue;
            }

            for(Pair p : adj.get(node)){
                int neigh=p.node;
                int wt=p.wt;
                if(stops+1<k && distance[neigh] >= dist + wt ){
                    distance[neigh] = dist + wt;
                    q.add(new Trio(neigh,distance[neigh],stops+1));
                }
            }
        }

        return distance[dst] ==(int) 1e9 ? -1 : distance[dst];


    }}
