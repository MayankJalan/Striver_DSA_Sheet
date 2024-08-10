package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceFromTheSource_Bellman_FordAlgorithm {
    static int[] bellman_ford(int v, ArrayList<ArrayList<Integer>> edges, int source) {
        int dist[] = new int[v];
        Arrays.fill(dist, (int) (1e9));
        dist[source] = 0;
        for (int i = 0; i < v - 1; i++) {
            for (List<Integer> arr : edges) {
                int s = arr.get(0);
                int d = arr.get(1);
                int w = arr.get(2);
                if (dist[s] == (int) (1e9)) {
                    continue;
                }
                dist[d] = Math.min(dist[d], dist[s] + w);
            }

        }
        return dist;
        // Write your code here
    }
}
